EASTER_EGG_URLS

## HTML Analyzer
## About the Project
The HTML Analyzer is a program designed to extract the text snippet located at the deepest level of an HTML structure from a given URL.

## Requirements
- JDK 17

- No external libraries or frameworks outside the JDK are allowed.

- Use of native JDK packages/classes related to HTML, XML, or DOM manipulation is prohibited.

- The program must output only the following to the console:
  a. The identified text snippet from the HTML.
  b. The message "malformed HTML".
  c. The message "URL connection error" (if HTML content cannot be retrieved due to connection failure).

## Classes Overview
- PageReader Class

- FindMessage Class

- HtmlAnalyzer Class

## PageReader Class
This class reads an HTML page and returns its content. It accepts a URL as a string and is divided into two methods:

## splittingStringInLines
A private static method that converts a URL string into a URL object using the URL class.

Returns an ArrayList<String> containing the HTML page content by calling the readContent method with the generated URL as input.

## readContent
A private static method that takes a URL object and creates an ArrayList<String>.

Uses try-with-resources for efficient resource management:

A BufferedReader reads the HTML content via InputStreamReader and openStream() (initiates a TCP connection to the URL’s server).

Each line is read in a while loop until content is null.

Each line is trimmed (removes leading/trailing spaces) to simplify processing in the FindMessage class and avoid empty/spaces-only lines.

Non-null lines are added to the ArrayList.

Complexity: O(n).

## FindMessage Class
This class extracts the text snippet at the deepest level of the HTML structure from an ArrayList<String>. It returns "malformed HTML" if the HTML is invalid.

## Key Components
Constant: MALFORMED_HTML = "malformed HTML".

## Local variables:

- int count: Tracks the current HTML nesting level.

- int maxValue: Stores the deepest level found.

- String message: Stores the text snippet at the deepest level.

- Stack<String> stack: Tracks opening tags (LIFO structure).

## Methods
- isOpenTag: Checks if a line is an opening tag (e.g., <div>).

- isCloseTag: Checks if a line is a closing tag (e.g., </div>).

- isNotATag: Checks if a line is plain text (not a tag).

- isMatchingTag: Validates if the last opened tag matches the closing tag.

# Algorithm
Iterates through each line in the ArrayList<String> (O(n) complexity).

Open Tag: Increments count, pushes the tag to the stack.

Close Tag:

- Decrements count.

- Checks if the tag matches the most recent opening tag (using stack.pop()).

- If mismatched, returns MALFORMED_HTML.

Text Snippet:

- If count > maxValue, updates maxValue and stores the line in message.

- Returns message or MALFORMED_HTML for invalid HTML.

## HtmlAnalyzer Class
The main class that integrates all components.

Handles command-line arguments:

Returns no output (as per requirements) if no argument is provided.

Processes the URL if one argument is given.

Manages exceptions:

- Outputs "URL connection error" for connection failures.

## Possible Improvements
- Argument Validation: Return an error message for invalid argument counts (e.g., zero or multiple arguments).

- Automated Unit Tests: Improve code maintainability with test coverage.