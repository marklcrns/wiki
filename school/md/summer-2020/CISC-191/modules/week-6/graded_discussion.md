---
title: Week 6 Graded Discussion
author: Mark Lucernas
date: 2020-07-20
summary: Week 6 Graded Discussion entry
---


# Networking Graded Discussion

**Q: If you are not using networking for your final projects, choose any two Data
Serialization Formats, compare and contrast them, briefly explain how to
integrate them into your Java app (with sample code), and provide use cases for
each.**

Answer:

Java serialization in comparison with JSON.

Serialization in general, is the process of translating a data structure or
object state into a format that can be stored, and de-serialization is
essentially reading the stored data structure or object back into its original
form.

Java serialization allows Java Object or data structure to be stored in a binary
file. Here is an example of java serialization

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Mark Lucernas
 * Date: 2020-07-20
 */
public class SerializationSample {

  public static void main(String[] args) throws IOException {
    // Create instance of an object
    Message msg = new Message("Hello World. Serialization sample");

    // Serialize Message object instance
    try {
      serialize(msg);
    } catch(NotSerializableException e) {
      e.printStackTrace();
    }

    // Deserialize Object from binary file
    Message deserializedMsg = (Message) deserialize(msg);

    // Print to check if it works
    System.out.println(deserializedMsg);
  }

  /** Store object into object.bin file
   * NOTE: does not require .bin file extension */
  public static void serialize(Object obj) throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.bin"));
    objectOutputStream.writeObject(obj);
    objectOutputStream.close();
  }

  /** Read serialized file and format into Java code */
  public static Object deserialize(Object obj) throws IOException {
    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.bin"));
    Object deserializedObject = null;

    try {
      // NOTE: Needs casting to convert into a specific Java object class
      deserializedObject = objectInputStream.readObject();
    } catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
    objectInputStream.close();

    return deserializedObject;
  }

}

class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  String message;

  public Message(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    String msg = "Message [" + message + "]";
    return "========================================\n" + msg + "\n========================================";
  }
}
```

This will create an object.bin file with contents that looks like this

```
¬ísrMessageLmessagetLjava/lang/String;xpt!Hello World. Serialization sample
```

And a console output of:

```
========================================
Message [Hello World. Serialization sample]
========================================
```

Java serialization should only be considered to be a Java-to-Java interaction
since its the serialization is built-in the Java API and the fact that bin files
it produce are Java specific. Also the binary files are not human or other
language readable.


While JSON is more human-readable and is basically JavaScript syntax (not to be
confused with Java Language which is very different). Its one of the ubiquitous
serialization format that can easily be parsed by many programming languages.
Here is an example of a JSON format file. NOTE: JSON files has .json file
extension.

```json
[
  {
    "name": "William",
    "last name": "Bailey",
    "dob": 1962,
    "nickname": "Axl Rose",
    "instruments": [
      "vocals",
      "piano"
    ]
  },
  {
    "name": "Saul",
    "last name": "Hudson",
    "dob": 1965,
    "nickname": "Slash",
    "instruments": [
      "guitar"
    ]
  }
]
```

from sitepoint.com

As you can see, its very readable and parseable as compared to the gibberish
binary file Java Serialization produce.



Conclusion: Project Use Case

We can use Java Serialization in our Wizard game project to save the current
state of the game by saving the all the relevant data into a binary file. Since
Java Serialization is built-in to Java API and is a "binary" file, it means its
faster? But according to a blog post, it isn't the most efficient performance
wise as it has many requirements. But it shines with compatibility with other
different Java version and I personally don't concern our project with
compatibility with other language for now.

JSON format in contrast, is really great and readable. Theres a Java library
made by Google called GSON that serialize Java Objects into JSON format. We can
even modify the .json file after being created.  But we wouldn't want users to
"cheat" and be able to modify the save game state and make the Wizard's ammo to
one million. So I personally think that Java Serialization, while being aware of
its drawbacks and strengths compatibility and performance-wise, would choose
over JSON serialization format (Although theres also BSON format thats basically
JSON but in binary format that is much faster in memory, but that's a different
story).


(Edited to update sources used)


<br>

# Resources

  - https://en.wikipedia.org/wiki/Comparison_of_data-serialization_formats
  - https://stackoverflow.com/questions/11102645/java-serialization-vs-json-vs-xml
  - https://www.javacodegeeks.com/2013/09/optimizing-java-serialization-java-vs-xml-vs-json-vs-kryo-vs-pof.html
  - https://github.com/google/gson
  - https://www.sitepoint.com/data-serialization-comparison-json-yaml-bson-messagepack/
  - http://bsonspec.org/
  - https://www.youtube.com/watch?v=vcV0DK45P-Q

