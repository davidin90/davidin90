md to html converter v3.0
==========================

Copyright (c) 2016 Software Engineering class. All rights reserved.

1.  Program description: This program provides some services to convert md file to a html file.

2.  How to use:
1)  Execute the MDParser.java in CMD using ant build script.
2)  If you type ¡°help¡± in CMD, the program will show you how to use program.
3)  If you type ¡°convert a.md to b.html plain¡± in CMD, the program will convert a.md file to b.html file. (The file names, a and b, are the arbitrary name)
4)  If you type ¡°quit¡± in CMD, the program will be exited.

3.  Software requirements:
1)  The .md file, which you want to change to html file, should be in your current project directory.
2)  The name of the .html file should differ from the name of the file in your current project directory.

4.  Available Syntax:
1) Headers
Header 1
========
# Header 1 #
## Header 2 ##
###### Header 6
2)Unordered Lists
*   A list item.
*   Bubbles
3) Code block
Indent every line of a code block by at least 4 spaces or 1 tab.
This is a normal paragraph.
    This is a preformatted
4) Block quotes
> Email-style angle brackets
> are used for block quotes.
> > And, they can be nested.
5) Horizontal Rules
Three or more dashes or asterisks:
---
*** 
6) Links
An [example](http://url.com/ "Title")
7) Images
![alt text](/path/img.jpg "Title")
8) Phrase Emphasis
*italic*   **bold**
_italic_   __bold__
This is *emphasis* and This is **Strong**
9) Code Spans
`<code>` spans are delimited by back ticks.
You can include literal back ticks like `` `this` ``.
10) Backslash
\\ backslash
\¡® backtick
\* asterisk
\_ underscore
\{ \} curly braces
\[ \] square brackets
\( \) parentheses
\# hash mark
\. Dot
\! exclamation mark

5. Copyright and License Information
Copyright (c) 2016 Software Engineering class. All rights reserved.