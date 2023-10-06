package com.github.jakub_galazka.java_in_nutshell._5io._1java_io;

import com.github.jakub_galazka.java_in_nutshell._5io.utils.IndexRecord;

import java.io.*;
import java.util.*;

/*
    IO can be performed using:
    ~ Byte data - binary format -> variables, classes
    ~ Character data - readable format -> csv, json, xml

    Files:
    ~ Serial file / Sequential file:
      the stream of data that arrives at program or is sent out from it in defined order
      witch each piece of data following in sequence.
    ~ Random access file:
      only applies to file and allows to jump about the file or within the file
      retrieving or overwriting any data in any location within that file
        -> like database: sort of index showing where particular record is within the file
                          so that it can be read without having to be read through the earlier records first.
*/

// Class that pretty much behaves just like a Map, but which we can customize to load its contents form an external source using SIB
public class _2JavaIO implements Map<Integer, _3Location> {

    private static final String LOCATIONS_TXT_PATH = "src/com/github/jakub_galazka/java_in_nutshell/_5io/utils/files/locations.txt";
    private static final String DIRECTIONS_TXT_PATH = "src/com/github/jakub_galazka/java_in_nutshell/_5io/utils/files/directions.txt";
    private static final String LOCATIONS_DAT_PATH = "src/com/github/jakub_galazka/java_in_nutshell/_5io/utils/files/locations.dat"; // .dat -> binary data
    private static final String LOCATIONS_OBJ_PATH = "src/com/github/jakub_galazka/java_in_nutshell/_5io/utils/files/locations_obj.dat";
    private static final String LOCATIONS_RAF_PATH = "src/com/github/jakub_galazka/java_in_nutshell/_5io/utils/files/locations_raf.dat";

    private static final Map<Integer, _3Location> locations = new LinkedHashMap<>();

    // For RandomAccessFile
    private static final Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    // ========================================================================================================================================================================================================

    /*
        Buffering - reducing the disk access time by reading / saving large chunks of the file from / into memory
            -> FileWriter / FileOutputStream puts data into the buffer and the data is only written to disk when the buffer is full.
            -> FileReader / FileInputStream reads data from the input stream and buffers the characters into a character array.
        ~ Buffering prevents reading / writing small amounts of data to the disk,
          witch is very efficient because the disk drive generally speaking is much slower than computer can process
          (it takes a while to find the correct place on the disk drive to write or read from).
        ~ Using the buffer data is written / read out in sizable chunks rather than sort of character at a time.
        ~ Size of buffer can be specified
            -> DEFAULT: 8k bytes
            -> 8k bytes put into the buffer in single write / read and be available from there
               FOR EXAMPLE: (reading) for the Scanner to use it as it needs more data.
    */

    // ========================================================================================================================================================================================================
    // WRITING TEXT DATA templates:

    // Try-catch
    private void writingTextDataWithTryCatch() {
        BufferedWriter locFile = null;
        try {
            locFile = new BufferedWriter(new FileWriter(LOCATIONS_TXT_PATH)); // Open stream
            // LOGIC START
            for (_3Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        } finally {                         // Regardless of what happened the finally blocked is executed
            try {                           // .close() throws IOException
                if (locFile != null) {      // IMPORTANT: be very careful not to cause more exceptions in the try block
                    locFile.close();        // STREAM MUST BE CLOSED!!!
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        [since Java 7] Try-with-resources
            -> automatically ensures that the stream is closed whether the code executes normally or an Exception occurs.

        This code does behave differently to the previous code (the Try-finally version):
        The differences occur if an Exception is thrown when closing the stream in addition to an error in the Try block.
        In the Try-finally example, it would have been the Exception that was thrown by the close method that was thrown up to the stack.
        But writing the code this way cause the Exception to be suppressed
        and the Exception from the Try block is the one that is actually thrown back up the stack.
        So that does actually make sense as it is very likely that whatever problem occurred
        while opening or writing to the stream is probably of more interest than the error closing the stream.
        In fact the first error is probably the root cause of the error when closing if you think about it.
        Using Try-finally the first error would be hidden by the Exception when closing the stream
        whereas this method ensures that the first error is the one thrown back.
    */
    private void writingTextDataWithTryWithResources() {
        // Try-with-resources allows more than one resource to be specified
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter(LOCATIONS_TXT_PATH));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter(DIRECTIONS_TXT_PATH))) {
            // LOGIC START
            for (_3Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================================================================================================================================================
    // READING TEXT DATA templates:

    // Try-catch | Using Scanner
    private void readingTextDataWithTryCatchUsingScanner() {
        Scanner scanner = null;

        // locations.txt
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LOCATIONS_TXT_PATH))); // Scanner gets data from the stream
            // LOGIC START
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                locations.put(loc, new _3Location(loc, description, null));
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
                /*
                    Scanner close() method also take care of closing any stream that it was using,
                    provided that the stream object implements the Closable interface
                 */
            }
        }

        // directions.txt
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DIRECTIONS_TXT_PATH)));
            // LOGIC START
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                _3Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // [since Java 7] Try-with-resources | Without Scanner
    private void readingTextDataWithTryWithResourcesWithoutScanner() {
        // locations.txt
        try (BufferedReader locFile = new BufferedReader(new FileReader(LOCATIONS_TXT_PATH))) {
            // LOGIC START
            String input;
            while ((input = locFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String description = data[1];
                System.out.println("Imported loc: " + loc + ": " + description);
                locations.put(loc, new _3Location(loc, description, null));
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        }

        // directions.txt
        try (BufferedReader dirFile = new BufferedReader(new FileReader(DIRECTIONS_TXT_PATH))) {
            // LOGIC START
            String input;
            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                _3Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================================================================================================================================================

    /*
        Writing / reading binary data:
        ~ Advantage of dealing with binary data (byte stream) is that the data does not have to be passed into the various data types that were stored.
          The reason for that is that a byte stream itself can be used to write and read any of the Java primitive types and also String variables.
        ~ FileOutputStream, FileInputStream, BufferOutputStream, BufferInputStream objects only handle raw bytes.
          So writing or reading either a single byte or a specified number of bytes.
        ~ Java IO package provides the DataInputStream and DataOutputStream classes,
          which provide methods such as readInt() to read an integer value from the stream.
          It does this by reading 4 bytes from the stream and building up the integer from them.
    */

    // ========================================================================================================================================================================================================
    // WRITING BINARY DATA template:

    private void writingBinaryData() {
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(LOCATIONS_DAT_PATH)))) {
            // LOGIC START
            for (_3Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription()); // To write Strings
                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================================================================================================================================================
    // READING BINARY DATA template:

    private void readingBinaryData() {
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream(LOCATIONS_DAT_PATH)))) {
            // LOGIC START
            boolean eof = false;
            while(!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0; i < numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new _3Location(locID, description, exits));
                } catch (EOFException e) {
                     /*
                        Data stream readers throw an EOFException (end of file exception: subclass of IOException)
                        when there is no more data to be read from the stream
                     */
                    eof = true;
                }
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================================================================================================================================================

    /*
        Object IO:
        ~ ObjectOutputStream / ObjectInputStream classes are used to write / read objects as a single unit.
        ~ To write an object to a file, it has to be translated to a format that can be stored to a file
          and then reassembled into an object later when it is read by an application.

        Serialization - the process of translating a data structures or object into a format that can be stored and recreated:
        ~ In Java when we want to use an object stream to write and read the object of a class, we have to make the class serializable
            -> we do so by making it implement the Serializable interface.
        ~ Serializable interface got no methods, it is just used to give JVM,
          a heads-up that we may want to serialize the object to storage and to read it back again at some point.
        ~ IMPORTANT: when we make a class serializable it is strongly recommended that we declare:
                     private long field called serialVersionUID
                     -> if we do not do so, the compiler will give us a warning.

        serialVersionUID - sort of version number for the class:
        ~ If we ever change a class, for example, by adding another filed or method or change a field type,
          we have to change the serialVersionUID value.
        ~ When the object is read from a stream,
          the runtime checks the stored serialVersionUID against the one contained within the compiled class file
            -> if they do not match, then there is a compatibility problem and the runtime will throw InvalidClassException.

        Note that:
        ~ The ObjectOutputStream / ObjectInputStream implements the interfaces DataOutputStream / DataInputStream.
        ~ Now the DataOutputStream and DataInputStream interfaces contain the declarations for:
          writeInt() / readInd() as well as writeUTF() / readUTF() methods and other read / write specific type methods.
        ~ Because of that, object streams can contain a mix of serialized objects and primitive types
            -> they are not limited to only containing serialized objects.
    */

    // ========================================================================================================================================================================================================
    // WRITING WHOLE OBJECTS template:

    // Serialized file will only ever contain one copy of the same instance
    public void writingObject() {
        try (ObjectOutputStream locObjFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(LOCATIONS_OBJ_PATH)))) {
            // LOGIC START
            for (_3Location location : locations.values()) {
                locObjFile.writeObject(location);
            }
            // LOGIC END
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================================================================================================================================================
    // READING WHOLE OBJECTS template:

    public void readingObject() {
        try (ObjectInputStream objectsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(LOCATIONS_OBJ_PATH)))) {
            // LOGIC START
            boolean eof = false;
            while (!eof) {
                try {
                    _3Location location = (_3Location) objectsFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
            // LOGIC END
        } catch (InvalidClassException e) {
            System.out.printf("InvalidClassException " + e.getMessage());
        } catch (IOException e) {
            System.out.printf("IOException " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Thrown when the runtime read an object from the stream, and it cannot find corresponding class on the class path
            System.out.printf("ClassNotFoundException " + e.getMessage());
        }
    }

    // ========================================================================================================================================================================================================

    /*
        Random Access File

        File Pointer:
        ~ When accessing a file in a random fashion, it is important to understand the concept of a File Pointer.
        ~ The File Pointer is an offset in the file where the next write / read will start from.
        ~ Offset in randomly accessing files - byte location in the file
            -> if the value has an offset of 100, that would mean that the value is located at byte 100 in the file,
               so we would want the File Pointer to be set to 100 when we write / read the value.
        ~ For example if the File Pointer is set to 100,
          then the next time we call a write / read method the write / read will start at byte position 100 in the file.
        ~ Now if we are reading an int the byte set positions 100 to 103 would be read since an int is 4 bytes
            -> IMPORTANT: the byte position is zero based.
        ~ Whenever we write or read the file, the File Pointer is advanced by the number of bytes we wrote / read.

        When using Random Access Files, we refer to each set of related data as a record.
        If all objects occupy the same length, and we wrote them out in order that is easy case
            -> we could figure out an object's offset from its ID and the fixed object length
            -> startByte = (n - 1) * fixedOccupiedBytes;
        But if the length of each object is different we have to include an Index in our file.

        Index in Random Access File:
        ~ For each data record that Index typically contains:
            1. Unique identifier
            2. The offset
            3. Record length
        ~ So every Index record has to be the same length -> in Java it is 12 bytes (3 ints)
        ~ Now given that reading an object (data record) is going to be a 2-step process:
            1. We are going to get the Index record for the object.
            2. We are going to use the Index values and read the object data.
        ~ We can access the Index record we need by reading it from the file when it is needed.
        ~ Or we could load the entire Index into memory when the application starts
            -> IDEALLY: we would want to load the Index into memory.
        ~ IMPORTANT: we have to save the offset of the data section
            -> that is typically saved near the top of the file.

        RandomAccessFile class:
        ~ When we want to move to a specific offset in file
            -> we use the RandomAccessFile seek() method to move the File Pointer.
        ~ When we want to do a bunch of sequential writes / reads,
          we will start by positioning the File Pointer to the offset of where the first write / read will take place.
          If the next write / read we want to do follows the previous one, we can just use the readInt() method, etc.
        ~ IMPORTANT: The File Pointer is always advanced by the number of bytes written or read.
          So if the next piece of data we want to read write immediately followed the last piece that we red or wrote,
          then the File Pointer will be already positioned correctly.

        File format for the example:
        1. This first 4 bytes will contain the number of objects (bytes 0-3).
        2. Next 4 bytes will contain the start offset of the objects section (bytes 4-7).
        3. Next section of the file will contain the Index (the Index is 1692 bytes long -> start at byte 8 and end at byte 1699).
        4. The final section of the file will contain the objects records (the data) -> start at byte 1700.
     */

    // ========================================================================================================================================================================================================
    // WRITING TO RANDOM ACCESS FILE:

    private void writingToRandomAccessFile() {
        /*
            2. argument ("rwd")
                -> indicates that we want to open the file for reading and writing and also that we want reads occur synchronously.
                   It can be open read only and can also not specify that updates to the file have to occur synchronously.
                   But if we do that and multiple threads it can access the file,
                   you would actually be responsible for synchronizing the code yourself.
                -> GOOD PRACTISE: to have the RandomAccessFile class handle the synchronization when it does matter
         */

        try (RandomAccessFile raf = new RandomAccessFile(LOCATIONS_RAF_PATH, "rwd")) {
            // 1.
            raf.writeInt(locations.size());

            // 2.
            // Each Index record will contain 4 integers: Location ID, the offset for the location and size (length) of the location record
            int indexSize = locations.size() * 3 * Integer.BYTES;
            // Casting needed -> .getFilePointer returns long value -> (currentPos + bytes for writing recordOffset value + indexSize)
            int recordsOffset = (int) (raf.getFilePointer() + Integer.BYTES + indexSize);
            raf.writeInt(recordsOffset);

            /*
                Before we can write the Index, we have to write the objects because each Index record requires the offset for the object.
                And of course, we do not know the offset until we have written the object.
                We could write then object and then write the index record for it and so on
                but that would actually involve a lot of jumping back and forth in the file.
                Now disk access is expensive, and it is even more expensive when it is not sequential.
                So instead, what we are going to do is write all the objects, and then we will write the index as a whole.
                Now to do that, what we have to do is build the Index in memory as we write the objects.
                Because we want to jump back to the file when we are finished writing the objects,
                we will save the current position of the File Pointer
                    -> so that we can jump back to it when we want to write the Index.
             */
            long indexOffset = raf.getFilePointer();

            // 4.
            int startPointer = recordsOffset;
            raf.seek(startPointer);

            for (_3Location location : locations.values()) {
                raf.writeInt(location.getLocationID());
                raf.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                raf.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (raf.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) raf.getFilePointer();
            }

            // 3.
            raf.seek(indexOffset);
            for (Integer locationID : index.keySet()) {
                raf.writeInt(locationID);
                raf.writeInt(index.get(locationID).getOffset());
                raf.writeInt(index.get(locationID).getLength());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================================================================================================================================================
    // READING FROM RANDOM ACCESS FILE:

    /*
        Location Random Access File Stream will have to remain open while the application runs
            -> so the close() stream method have to be provided in wrapper class
     */
    private void readingFromRandomAccessFile() {
        try {
            ra = new RandomAccessFile(LOCATIONS_RAF_PATH, "rwd");
            int locationsNum = ra.readInt();
            int recordsOffset = ra.readInt();

            while (ra.getFilePointer() < recordsOffset) {
                int locationId = ra.readInt();
                int locationOffset = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord indexRecord = new IndexRecord(locationOffset, locationLength);
                index.put(locationId, indexRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getting object (Location) form Random Access File
    public _3Location getLocation(int locationId) throws IOException {
        IndexRecord indexRecord = index.get(locationId);
        ra.seek(indexRecord.getOffset());

        int id = ra.readInt();
        /*
            The readUTF() method knows how many bytes should be read
                -> because the writeUTF() method actually writes the length of the String followed by the String itself
                -> so the readUTF() method reads the length first, and then it reads the appropriate number of bytes
         */
        String description= ra.readUTF();
        String exits = ra.readUTF();

        String[] exitsPart = exits.split(",");
        _3Location location = new _3Location(locationId, description, null);
        if (locationId != 0) {
            for (int i = 0; i < exitsPart.length; i++) {
                System.out.println("exitsPart = " + exitsPart[i]);
                System.out.println("exitsPart[+1] = " + exitsPart[i + 1]);
                String direction = exitsPart[i];
                int destination = Integer.parseInt(exitsPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
    }

    // Method for closing Random Access File stream
    public void close() throws IOException {
        if (ra != null) {
            ra.close();
        }
    }

    // ========================================================================================================================================================================================================
    // Map interface methods

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public _3Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public _3Location put(Integer key, _3Location value) {
        return locations.put(key, value);
    }

    @Override
    public _3Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends _3Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<_3Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, _3Location>> entrySet() {
        return locations.entrySet();
    }
}
