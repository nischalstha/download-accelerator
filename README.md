# download-accelerator

A program to develop a download accelerator tool by working with TCP Server and
TCP Client.

**Analysis**

The first task that was performed was I had to clearly understand the requirements
and functional specification by detailing a flow of events for the program. I analyzed
the program by trying to state the program’s purpose in simple English language and
thinking about how I would have solved the program.

I have a file. I partition the file to 5 smaller files.
I create a server class with five sockets open and send each of the file to client.
I create a client class with five sockets open and receive each of file file from server.
I have five files received from the client. I merge those files in one file and save on
disk.

Next, I understand on what kind of information (data analysis) my classes would
operate on. I have a clear understanding about what are required resources that
needs to be gathered to finish the program.

By using Use cases, I represented the tasks that needs to be performed by the
program. The basic use case of this project is to send and receive files through server
and clients using threads. As a whole, this program is a download accelerator, where a
file is downloaded by being partitioned into smaller files and later joined to make a
whole file.

**Design**

This phase was all about identifying state, behavior of classes and objects and their
relationships. A skeleton of the program was first drafted on specifying what each
classes needs to perform. For this project, I created two classes, “TCPServerNischal”
and “TCPClientNischal”. “TCPServerNischal” would partition a original file into five
smaller files, send the smaller files to “TCPClientNischal” by creating five sockets.
The time taken to complete each thread was calculated in nano seconds after each
thread started.
