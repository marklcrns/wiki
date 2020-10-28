---
title: Java Networking
author: Mark Lucernas
date: 2020-07-20
summary: Java Networking, Socket Programming.
---


# Java Networking

- [⬇ Networking](file:../../../../../../../files/summer-2020/CISC-191/week-6/networking.ppt)
- [📄 Server.java](https://liveexample.pearsoncmg.com/html/Server.html)
- [📄 Client.java](https://liveexample.pearsoncmg.com/html/Client.html)
- [📄 MultiThreadServer.java](https://liveexample.pearsoncmg.com/html/MultiThreadServer.html)
- [📄 StudentAddress.java](https://liveexample.pearsoncmg.com/html/StudentAddress.html)
- [📄 StudentServer.java](https://liveexample.pearsoncmg.com/html/StudentServer.html)
- [📄 StudentClient.java](https://liveexample.pearsoncmg.com/html/StudentClient.html)
- [📄 TicTacToeServer](https://liveexample.pearsoncmg.com/html/TicTacToeServer.html)
- [📄 TicTacToeClient](https://liveexample.pearsoncmg.com/html/TicTacToeClient.html)
- [📄 DatagramServer](https://liveexample.pearsoncmg.com/html/DatagramServer.html)
- [📄 DatagramClient](https://liveexample.pearsoncmg.com/html/DatagramClient.html)
- [📺 Java Socket Programming](https://www.youtube.com/watch?v=-xKgxqG411c)

## Client/Server Communications

### The InetAddress Class

Occasionally, you would like to know who is connecting to the server. You can
use the `InetAddress` class to find the client's host name and IP address. The
InetAddress class models an IP address. You can use the statement shown below to
create an instance of InetAddress for the client on a socket.

```java
InetAddress inetAddress = socket.getInetAddress();
```

Next, you can display the client's host name and IP address, as follows:

```java
System.out.println("Client's host name is " + inetAddress.getHostName());
System.out.println("Client's IP Address is " + inetAddress.getHostAddress());
```

### Serving Multiple clients

Multiple clients are quite often connected to a single server at the same time.
Typically, a server runs constantly on a server computer, and clients from all
over the Internet may want to connect to it. You can use threads to handle the
server's multiple clients simultaneously. Simply create a thread for each
connection. Here is how the server handles the establishment of a connection:

```java
while (true) {
  Socket socket = serverSocket.accept();
  Thread thread = new ThreadClass(socket);
  thread.start();
}
```

### Stream Socket vs Datagram Socket

<a name="stream-socket-term">**Stream socket**</a>

  - A dedicated point-to-point channel between a client and server.
  - Use TCP (Transmission Control Protocol) for data transmission.
  - Lossless and reliable.
  - Sent and received in the same order.


<a name="datagram-socket-term">**Datagram socket**</a>

  - No dedicated point-to-point channel between a client and server.
  - Use UDP (User Datagram Protocol) for data transmission.
  - May lose data and not 100% reliable.
  - Data may not received in the same order as sent.


#### DatagramPacket

The DatagramPacket class represents a datagram packet. Datagram packets are used
to implement a connectionless packet delivery service. Each message is routed
from one machine to another based solely on information contained within the
packet.

#### DatagramSocket

The DatagramSocket class represents a socket for sending and receiving datagram
packets. A datagram socket is the sending or receiving point for a packet
delivery service. Each packet sent or received on a datagram socket is
individually addressed and routed. Multiple packets sent from one machine to
another may be routed differently, and may arrive in any order.

#### Datagram Programming

Datagram programming is different from stream socket programming in the sense
that there is no concept of a ServerSocket for datagrams. Both client and server
use DatagramSocket to send and receive packets.


<br>

# Resources

- [⬇ Networking](file:../../../../../../../files/summer-2020/CISC-191/week-6/networking.ppt)
- [📄 Server.java](https://liveexample.pearsoncmg.com/html/Server.html)
- [📄 Client.java](https://liveexample.pearsoncmg.com/html/Client.html)
- [📄 MultiThreadServer.java](https://liveexample.pearsoncmg.com/html/MultiThreadServer.html)
- [📄 StudentAddress.java](https://liveexample.pearsoncmg.com/html/StudentAddress.html)
- [📄 StudentServer.java](https://liveexample.pearsoncmg.com/html/StudentServer.html)
- [📄 StudentClient.java](https://liveexample.pearsoncmg.com/html/StudentClient.html)
- [📄 TicTacToeServer](https://liveexample.pearsoncmg.com/html/TicTacToeServer.html)
- [📄 TicTacToeClient](https://liveexample.pearsoncmg.com/html/TicTacToeClient.html)
- [📄 DatagramServer](https://liveexample.pearsoncmg.com/html/DatagramServer.html)
- [📄 DatagramClient](https://liveexample.pearsoncmg.com/html/DatagramClient.html)
- [📺 Java Socket Programming](https://www.youtube.com/watch?v=-xKgxqG411c)

