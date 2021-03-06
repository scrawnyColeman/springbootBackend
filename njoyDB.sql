-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jul 31, 2020 at 10:51 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `njoy_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `id` int(11) NOT NULL,
  `answer` varchar(2550) NOT NULL,
  `is_correct` tinyint(1) NOT NULL,
  `response_message` varchar(255) NOT NULL,
  `answer_type_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`id`, `answer`, `is_correct`, `response_message`, `answer_type_id`, `question_id`) VALUES
(1, 'A condition that returns a value without making any subsequent recursive calls', 1, 'Fantastic. Spot on!', 2, 1),
(2, 'The first recursive case', 0, 'Incorrect: A base case ends the recursive function, therefore it doesn\'t tend to happen straight away.', 2, 1),
(3, 'The final call added to the stack before stack overflow occurs', 0, 'Incorrect: stack overflow comes as a result of the compiler reaching its call limit. This is not related to a base case.', 2, 1),
(4, 'True', 0, 'Incorrect: Recursion can be faster but is not always.', 2, 2),
(5, 'False', 1, 'Fantastic! Recursion is not always faster.', 2, 2),
(21, 'a', 1, 'yes', 2, 33),
(22, 'b ', 0, 'no', 2, 33),
(23, 'a ', 1, 'yes', 2, 34),
(24, 'c', 0, 'no', 2, 33),
(25, 'b', 0, 'no', 2, 34),
(26, 'b', 0, 'no', 2, 34);

-- --------------------------------------------------------

--
-- Table structure for table `answer_types`
--

CREATE TABLE `answer_types` (
  `id` int(11) NOT NULL,
  `type_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `answer_types`
--

INSERT INTO `answer_types` (`id`, `type_name`) VALUES
(1, 'code'),
(2, 'text');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `parent_comment_id` int(11) NOT NULL,
  `nesting_value` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `comment`, `parent_comment_id`, `nesting_value`, `author_id`, `post_id`) VALUES
(1, 'This comment has been deleted', 0, 0, 9999, 6),
(2, 'Oh okay that sucks', 1, 1, 1, 6),
(3, 'Helpful comment. Good Job... OP, you can use arraylists for certain use cases but not others. arraylists tend to be more useful when quick access to elements is needed due to their structure', 1, 1, 2, 6),
(4, 'Thanks', 3, 2, 1, 6),
(5, 'See above', 0, 0, 2, 6),
(6, 'hi', 0, 0, 1, 6),
(11, 'hello', 6, 1, 2, 6),
(12, 'whoops', 11, 2, 2, 6),
(13, 'noooo', 5, 1, 2, 6),
(14, 'Question: what is the base in the practical?', 0, 0, 2, 1),
(16, 'mistake', 14, 1, 1, 1),
(17, 'and the pattern is 0 1 1 2 3 5 8 13 21...', 14, 1, 1, 1),
(18, 'So Fib(0) = 0. Fib(1) = 1. Fib(2) = 1\r\n\r\n...', 14, 1, 1, 1),
(20, 'This can then be written as: when n is 0, Fib(n) is 0. Likewise, when n is 1, Fib(n) is 1. But when n is 2, Fib(n) is not 2.', 18, 2, 1, 1),
(21, 'And as a result, the base case is: if (n == 0 or n == 1) Fib(n) = n', 18, 2, 1, 1),
(22, 'This comment has been deleted.', 18, 2, 9999, 1),
(23, 'This comment has been deleted.', 0, 0, 9999, 11),
(24, 'This comment has been deleted.', 23, 1, 9999, 11),
(25, 'This comment has been deleted.', 0, 0, 9999, 11),
(26, 'This comment has been deleted.', 0, 0, 9999, 11),
(27, 'This comment has been deleted.', 26, 1, 9999, 11),
(28, 'This comment has been deleted.', 27, 2, 9999, 11),
(29, 'hi', 0, 0, 1, 1),
(30, 'hello', 0, 0, 1, 1),
(31, 'This comment has been deleted.', 0, 0, 9999, 22),
(32, 'hello', 0, 0, 1, 23),
(33, 'This comment has been deleted.', 0, 0, 9999, 23),
(34, 'hello', 32, 1, 2, 23),
(36, 'hi', 0, 0, 3, 24),
(37, 'hi', 0, 0, 3, 1),
(38, 'no', 30, 1, 3, 1),
(39, 'poor conduct', 29, 1, 3, 1),
(40, 'This comment has been deleted.', 0, 0, 9999, 1),
(41, 'help pls', 0, 0, 10019, 26),
(42, 'This comment has been deleted.', 0, 0, 9999, 27),
(43, 'no', 0, 0, 10020, 27);

-- --------------------------------------------------------

--
-- Table structure for table `forum_posts`
--

CREATE TABLE `forum_posts` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `question` varchar(2550) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `forum_posts`
--

INSERT INTO `forum_posts` (`id`, `title`, `question`, `lesson_id`) VALUES
(1, NULL, NULL, 1),
(2, NULL, NULL, 2),
(6, 'ArrayLists vs LinkedLists', 'Could anybody help me to understand the difference between ArrayLists and LinkedLists?', NULL),
(7, NULL, NULL, 3),
(8, NULL, NULL, 4),
(11, 'Recursion base case', 'I was hoping someone could explain base case please.', NULL),
(12, 'Building Web Applications', 'What is the best tech stack for building web apps?', NULL),
(13, 'Web App vs Mobile App', 'React or React Native?', NULL),
(22, 'Hello', 'this is a question', NULL),
(23, 'Hi', 'Whats up my guy', NULL),
(24, NULL, NULL, 6),
(26, 'React compoonents', 'cant figure them out...', NULL),
(27, 'Help. Im stuck', NULL, NULL),
(28, NULL, NULL, 33);

-- --------------------------------------------------------

--
-- Table structure for table `languages`
--

CREATE TABLE `languages` (
  `id` int(11) NOT NULL,
  `language` varchar(255) NOT NULL,
  `img_path` varchar(255) NOT NULL,
  `icon_path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `languages`
--

INSERT INTO `languages` (`id`, `language`, `img_path`, `icon_path`) VALUES
(1, 'java', 'JavaImg', 'JavaIcon'),
(2, 'javascript', 'JSImg', 'JSIcon'),
(3, 'python', 'PythonImg', 'PythonIcon');

-- --------------------------------------------------------

--
-- Table structure for table `lessons`
--

CREATE TABLE `lessons` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `theory` text,
  `yt_link` varchar(255) NOT NULL,
  `users_taken` int(11) NOT NULL DEFAULT '0',
  `is_approved` tinyint(1) NOT NULL DEFAULT '0',
  `language_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lessons`
--

INSERT INTO `lessons` (`id`, `title`, `description`, `theory`, `yt_link`, `users_taken`, `is_approved`, `language_id`) VALUES
(1, 'Recursion', 'Learn recursive functions to ace all of your coding interviews. We recommend that all users complete our loops and conditionals lesson before beginning here.', 'A common computer programming tactic is to divide a problem into sub-problems of the same type as the original, solve those sub-problems, and combine the results. This is often referred to as the divide-and-conquer method; when combined with a lookup table that stores the results of solving sub-problems (to avoid solving them repeatedly and incurring extra computation time), it can be referred to as dynamic programming or memoization.\\n\r\n            A recursive function definition has one or more base cases, meaning input(s) for which the function produces a result trivially (without recurring), and one or more recursive cases, meaning input(s) for which the program recurs (calls itself). For example, the factorial function can be defined recursively by the equations 0! = 1 and, for all n > 0, n! = n(n − 1)!. Neither equation by itself constitutes a complete definition; the first is the base case, and the second is the recursive case. Because the base case breaks the chain of recursion, it is sometimes also called the \"terminating case\".\\n\r\n            The job of the recursive cases can be seen as breaking down complex inputs into simpler ones. In a properly designed recursive function, with each recursive call, the input problem must be simplified in such a way that eventually the base case must be reached. (Functions that are not intended to terminate under normal circumstances—for example, some system and server processes—are an exception to this.) Neglecting to write a base case, or testing for it incorrectly, can cause an infinite loop.\\n\r\n            For some functions (such as one that computes the series for e = 1/0! + 1/1! + 1/2! + 1/3! + ...) there is not an obvious base case implied by the input data; for these one may add a parameter (such as the number of terms to be added, in our series example) to provide a \'stopping criterion\' that establishes the base case. Such an example is more naturally treated by co-recursion, where successive terms in the output are the partial sums; this can be converted to a recursion by using the indexing parameter to say \"compute the nth term (nth partial sum)', 'https://www.youtube.com/watch?v=Mv9NEXX1VHc&feature=emb_title', 2, 1, 2),
(2, 'Lambda Functions', 'Produce concise lambda functions to enhance your functional programming skills.', 'One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. In these cases, you\'re usually trying to pass functionality as an argument to another method, such as what action should be taken when someone clicks a button. Lambda expressions enable you to do this, to treat functionality as method argument, or code as data.', 'https://www.youtube.com/watch?v=yb46iD5dJYY', 1, 1, 1),
(3, 'Methods', 'Learn Java Methods', 'A method is a collection of statements that perform some specific task and return the result to the caller. A method can perform some specific task without returning anything. Methods allow us to reuse the code without retyping the code. In Java, every method must be part of some class which is different from languages like C, C++, and Python.\r\nMethods are time savers and help us to reuse the code without retyping the code.\r\n\r\nMethod Declaration\r\n\r\nIn general, method declarations has six components :\r\n\r\nModifier-: Defines access type of the method i.e. from where it can be accessed in your application. In Java, there 4 type of the access specifiers.\r\npublic: accessible in all class in your application.\r\nprotected: accessible within the class in which it is defined and in its subclass(es)\r\nprivate: accessible only within the class in which it is defined.\r\ndefault (declared/defined without using any modifier) : accessible within same class and package within which its class is defined.\r\nThe return type : The data type of the value returned by the method or void if does not return a value.\r\nMethod Name : the rules for field names apply to method names as well, but the convention is a little different.\r\nParameter list : Comma separated list of the input parameters are defined, preceded with their data type, within the enclosed parenthesis. If there are no parameters, you must use empty parentheses ().\r\nException list : The exceptions you expect by the method can throw, you can specify these exception(s).\r\nMethod body : it is enclosed between braces. The code you need to be executed to perform your intended operations.', 'https://www.youtube.com/watch?v=r0SewFmbCUI', 1, 1, 1),
(4, 'Interfaces', 'Learn OOP Interfaces', 'Like a class, an interface can have methods and variables, but the methods declared in an interface are by default abstract (only method signature, no body).  \r\n\r\nInterfaces specify what a class must do and not how. It is the blueprint of the class.\r\nAn Interface is about capabilities like a Player may be an interface and any class implementing Player must be able to (or must implement) move(). So it specifies a set of methods that the class has to implement.\r\nIf a class implements an interface and does not provide method bodies for all functions specified in the interface, then the class must be declared abstract.\r\nA Java library example is, Comparator Interface. If a class implements this interface, then it can be used to sort a collection.\r\nSyntax :\r\n\r\ninterface <interface_name> {\r\n    \r\n    // declare constant fields\r\n    // declare methods that abstract \r\n    // by default.\r\n}\r\n\r\nTo declare an interface, use interface keyword. It is used to provide total abstraction. That means all the methods in an interface are declared with an empty body and are public and all fields are public, static and final by default. A class that implements an interface must implement all the methods declared in the interface. To implement interface use implements keyword.\r\n\r\nWhy do we use interface ?\r\n\r\nIt is used to achieve total abstraction.\r\nSince java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance .\r\nIt is also used to achieve loose coupling.\r\nInterfaces are used to implement abstraction. So the question arises why use interfaces when we have abstract classes?\r\n', 'https://www.youtube.com/watch?v=fX1xNMBTMfg', 1, 1, 1),
(5, 'Loops', 'Learn how to utilise Loops in your programs.', 'The Java for loop is used to iterate a part of the program several times. If the number of iteration is fixed, it is recommended to use for loop.\r\n\r\nThere are three types of for loops in java.\r\n\r\nSimple For Loop\r\nFor-each or Enhanced For Loop\r\nLabeled For Loop\r\nJava Simple For Loop\r\nA simple for loop is the same as C/C++. We can initialize the variable, check condition and increment/decrement value. It consists of four parts:\r\n\r\nInitialization: It is the initial condition which is executed once when the loop starts. Here, we can initialize the variable, or we can use an already initialized variable. It is an optional condition.\r\nCondition: It is the second condition which is executed each time to test the condition of the loop. It continues execution until the condition is false. It must return boolean value either true or false. It is an optional condition.\r\nStatement: The statement of the loop is executed each time until the second condition is false.\r\nIncrement/Decrement: It increments or decrements the variable value. It is an optional condition.', 'https://www.youtube.com/watch?v=guXgBe2wvEA', 1, 1, 1),
(6, 'Conditionals', 'Learn to use if statements to create intelligent programs that can make decisions.', 'Relational operators are used to check conditions like whether two values are equal, or whether one is greater than the other. The following expressions show how they are used:\r\n\r\nx == y          // x is equal to y\r\nx != y          // x is not equal to y\r\nx > y           // x is greater than y\r\nx < y           // x is less than y\r\nx >= y          // x is greater than or equal to y\r\nx <= y          // x is less than or equal to y\r\nThe result of a relational operator is one of two special values, true or false. These values belong to the data type boolean; in fact, they are the only boolean values.\r\n\r\n\r\nYou are probably familiar with these operations, but notice that the Java operators are different from the mathematical symbols like =, ≠, and ≤. A common error is to use a single = instead of a double ==. Remember that = is the assignment operator, and == is a comparison operator. Also, there is no such thing as the =< or => operators.\r\n\r\nThe two sides of a relational operator have to be compatible. For example, the expression 5 < \"6\" is invalid because 5 is an int and \"6\" is a String. When comparing values of different numeric types, Java applies the same conversion rules we saw previously with the assignment operator. For example, when evaluating the expression 5 < 6.0, Java automatically converts the 5 to 5.0.\r\n\r\nMost relational operators don’t work with strings. But confusingly, == and != do work with strings – they just don’t do what you expect. We’ll explain what they do later; in the meantime, don’t use them with strings. Instead, you should use the equals method:\r\n\r\nString fruit1 = \"Apple\";\r\nString fruit2 = \"Orange\";\r\nSystem.out.println(fruit1.equals(fruit2));\r\nThe result of fruit1.equals(fruit2) is the boolean value false.\r\n\r\nRelational operators are used to check conditions like whether two values are equal, or whether one is greater than the other. The following expressions show how they are used:\r\n\r\nx == y          // x is equal to y\r\nx != y          // x is not equal to y\r\nx > y           // x is greater than y\r\nx < y           // x is less than y\r\nx >= y          // x is greater than or equal to y\r\nx <= y          // x is less than or equal to y\r\nThe result of a relational operator is one of two special values, true or false. These values belong to the data type boolean; in fact, they are the only boolean values.\r\n\r\n\r\nYou are probably familiar with these operations, but notice that the Java operators are different from the mathematical symbols like =, ≠, and ≤. A common error is to use a single = instead of a double ==. Remember that = is the assignment operator, and == is a comparison operator. Also, there is no such thing as the =< or => operators.\r\n\r\nThe two sides of a relational operator have to be compatible. For example, the expression 5 < \"6\" is invalid because 5 is an int and \"6\" is a String. When comparing values of different numeric types, Java applies the same conversion rules we saw previously with the assignment operator. For example, when evaluating the expression 5 < 6.0, Java automatically converts the 5 to 5.0.\r\n\r\nMost relational operators don’t work with strings. But confusingly, == and != do work with strings – they just don’t do what you expect. We’ll explain what they do later; in the meantime, don’t use them with strings. Instead, you should use the equals method:\r\n\r\nString fruit1 = \"Apple\";\r\nString fruit2 = \"Orange\";\r\nSystem.out.println(fruit1.equals(fruit2));\r\nThe result of fruit1.equals(fruit2) is the boolean value false.\r\n\r\n', 'https://www.youtube.com/watch?v=fsTC0Mqy0EU', 1, 1, 1),
(10, 'fdf', 'fad', 'fsf', 'daf', 0, 0, 1),
(11, 'Default title', 'There is no description for this lesson.', 'There is no theory for this lesson.', '', 0, 0, 1),
(12, 'a', 'a', 'a', 'a', 0, 0, 1),
(13, 'a', 'a', 'a', 'a', 0, 0, 1),
(14, 'a', 'a', 'a', 'a', 0, 0, 1),
(15, 'b', 'b', 'b', 'b', 0, 0, 1),
(16, 'c', 'c', 'c', 'cc', 0, 0, 1),
(17, 'd', 'd', 'd', 'd', 0, 0, 1),
(18, 'e', 'e', 'e', 'e', 0, 0, 1),
(19, 'g', 'gg', 'g', 'g', 0, 0, 1),
(20, 'h', 'h', 'h', 'h', 0, 0, 1),
(21, 'i', 'i', 'i', 'i', 0, 0, 1),
(22, 'j', 'j', 'j', 'j', 0, 0, 1),
(23, 'k', 'k', 'k', 'k', 0, 0, 1),
(24, 'l', 'l', 'l', 'l', 0, 0, 1),
(25, 'q', 'q', 'q', 'q', 0, 0, 1),
(26, 'p', 'p', 'p', 'p', 0, 0, 2),
(27, 'w', 'w', 'w', 'w', 0, 0, 1),
(28, 'z', 'z', 'z', 'z', 0, 0, 1),
(29, 'e', 'e', 'e', 'e', 0, 0, 1),
(30, '9', '9', '9', '9', 0, 0, 1),
(31, 'Default Title', 'Learn default lesson.', 'This is some sample theory', 'youtube.com/sampleLink', 0, 0, 1),
(32, 'Attempt 2', 'description 2', 'theory 2', 'youtubeURL2', 0, 0, 1),
(33, 'Recursion', 'Description', 'recursion theory', 'youtube lin', 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `practicals`
--

CREATE TABLE `practicals` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `code_snippet` varchar(2550) DEFAULT NULL,
  `hint` varchar(255) DEFAULT NULL,
  `lesson_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `practicals`
--

INSERT INTO `practicals` (`id`, `title`, `question`, `code_snippet`, `hint`, `lesson_id`) VALUES
(1, 'Fibonacci', 'Given the following iterative approach to the Fibonacci sequence, attempt to recreate the same result using Recursion', 'function Fib(var num){\r\n    if( num < 2 ){\r\n        return num\r\n    }\r\n    var first = 0\r\n    var second = 1\r\n    var temporaryVariable = 1\r\n    for(var i = 2; i <= num; i++){\r\n        temporaryVariable= first + second;\r\n        first = second;\r\n        second = temporaryVariable;\r\n    }\r\n    return temporaryVariable\r\n}', 'The formula is:\r\nfib(n) = fib(n-1) + fib(n-2)', 1),
(22, 'Substring', 'Write a recursive method to reverse a string.', 'public String reverseString(String wordToReverse){\n    \n    String reversedWord;\n\n    //write your code here...\n    //\n    //\n    //\n\n    return reversedWord;\n\n}', 'Build from the code below...', 33);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `question` varchar(2550) NOT NULL,
  `code_snippet` varchar(2550) DEFAULT NULL,
  `lesson_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question`, `code_snippet`, `lesson_id`) VALUES
(1, 'Which of the following best describes the base case?', NULL, 1),
(2, 'Recursive is always faster than the equivalent iterative approach. Is this statement true?', NULL, 1),
(5, 'Sample Question', NULL, 6),
(33, 'what is', NULL, 33),
(34, 'who are', NULL, 33);

-- --------------------------------------------------------

--
-- Table structure for table `recommended_prerequisites`
--

CREATE TABLE `recommended_prerequisites` (
  `id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `recommended_lesson_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recommended_prerequisites`
--

INSERT INTO `recommended_prerequisites` (`id`, `lesson_id`, `recommended_lesson_id`) VALUES
(1, 2, 4),
(2, 2, 3),
(3, 1, 6),
(4, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `solutions`
--

CREATE TABLE `solutions` (
  `id` int(11) NOT NULL,
  `code_snippet` varchar(2550) DEFAULT NULL,
  `explanation` text NOT NULL,
  `practical_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `solutions`
--

INSERT INTO `solutions` (`id`, `code_snippet`, `explanation`, `practical_id`) VALUES
(1, 'function Fib(var num) {\r\n    if( number < 2 ){\r\n        return num;\r\n    } else {\r\n        return Fib(num - 1) + Fib(num - 2);\\n\\t\r\n    }\r\n}', 'The recursive method (algorithm) ‘unwinds’ the number you give it until it can get an actual value (0 or 1), and then adds that to the total. The “unwinding” takes place each time the value of ‘number-2’ and the value of ‘number-1’ is given to the fibonacci method when the line\\n\r\n                fibonacci(number-2) + fibonacci(number-1)\\n\r\n                is evaluated. Note that the value of ‘number-2’ in this case is the value of the next instance of the fibonacci method’s variable number (next recursive loop). The same goes for the value of ‘number-1’.\r\n                With each recursion where the method variable number is NOT smaller than 2, the state or instance of the fibonacci method is stored in memory, and the method is called again. Each time the fibonacci method is called though, the value passed in is less than the value passed in during the previous recursive call (by either 1 or 2). This goes on until the value returned is a value smaller than 2 (either 0 or 1). The resolution of the previous instance can then be done. In one instance, 0 is returned and fibonacci(0) can be resolved to 0. In another, 1 is returned and fibonacci(1) can be resolved to 1.\r\n                These values are then summed in order to obtain the requested Fibonacci number. This summing action happens each time a 0 or 1 is returned from one instance of the fibonacci method to the previous instance of the fibonacci method, and so on.\r\n                This is equivalent to where all the 1’s and 0’s at the bottom of the tree structure are added together. The final sum (or total) of all these 0\'s and 1\'s is then the value of the Fibonacci number requested in the first place. This value is returned during the final return of the fibonacci method to where the method was called from in the first place.', 1),
(19, '//some code solution', 'Explanation', 22);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `email` varchar(255) NOT NULL,
  `user_role_id` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password_hash`, `enabled`, `email`, `user_role_id`) VALUES
(1, 'scrawnycoleman', '$2y$12$HU4XX8kxVFT3yCeYHeJDa.22xMmby5zxcS47xYMVUwePxa.9rXIxG', 1, 'randomemail@email.com', 2),
(2, 'skinnypaddy', '$2y$12$HU4XX8kxVFT3yCeYHeJDa.22xMmby5zxcS47xYMVUwePxa.9rXIxG', 1, 'sample@email.com', 2),
(3, 'admin', '$2y$12$HU4XX8kxVFT3yCeYHeJDa.22xMmby5zxcS47xYMVUwePxa.9rXIxG', 1, 'admin@njoy.com', 3),
(9999, 'anon', '$2y$12$iIvpWDkdxGrRYij/2mo0c.1bnaLO5G.7pqq1eVhEoPRtVKb7nLeBa', 1, 'anon@anon.com', 1),
(10000, 'butter', 'sa', 1, 'email', 1),
(10001, 'bap', 'Password1', 1, 'test@test.com', 1),
(10002, 'user', '$2a$10$kZc7hW1OtMRrXqYjaYWw0OuxTvvYAdYpwzLz9VWXmzxhTaLiSmttO', 1, 'test@test.com', 1),
(10003, 'user', '$2a$10$L3Zn3Jldbnyo3lAzC20UU.OOdWdKOIWss5YyG54hWf0TndDRv3yU.', 1, 'test@test.com', 1),
(10004, 'scra', '$2a$10$9QjZaex7.403E9clU20wEuq03PF.p5Mfu2sUFngONbZjORoR3N0By', 1, 'arc', 1),
(10005, 'scrawny', '$2a$10$PJn3Eof0Ts8kMJQ8BYAh9OENwwBN3MCHuC6ca/DYviGC5zYCMOrr6', 1, 'scrawny@coleman.com', 1),
(10006, 'testUser', 'dummy', 1, 'test@test.com', 1),
(10007, 'scrawnypaddy', 'Password1', 1, 'scrawny@paddy.com', 1),
(10008, 'scrawnypaddy2', '$2a$10$r2MB2nFpqghIDG6vqFR3YODBwbZSjj/DdL8OFURlNpHYqeuclXB12', 1, 'scrawny@paddy.com2', 1),
(10009, 'slumdogmillionaire', '$2a$10$Ybwxc6ABSrrrX/oWrApyDOQ4lf.14cRy7MiQ9F8k8aVeMtmelU21G', 1, 'testemail@test.com', 1),
(10010, 'ronnie', '$2a$10$nEbklhPSz6h.9EY.rEnm5uRqZxptykG71AQxtubreXFw5GEgUBqLK', 1, 'coleman', 1),
(10011, 'ScrawnyColeman_', '$2a$10$zN2L8UrUc1NcShH7cH6Haepf368gvMMxblAbbTz154k6trGdpoUnW', 1, 'coleman@email.com', 1),
(10012, 'brian', '$2a$10$tQmHtY8O3jL2TC0vJJNpeOdlzbkuaNAzTpoROdyLhcMA8OhOyz6K2', 1, 'brian@brian.com', 1),
(10013, 'sarah', '$2a$10$iYb7A4L0iKj3kMID0130eewoY6JOPuKkI0sFHrOvKSYh0BAYkqihO', 1, 'sarah@email.com', 1),
(10014, 'meme', '$2a$10$aLXw6jkCRV/JaQML9IJLCu97mmr522glHK6foaqSFnq.NhMN6gBJ6', 1, 'supreme', 1),
(10015, 'thetestuser', '$2a$10$cc6qVkCsXA8BKgQsRj1WqeApQBhDRNFTb6tRNRRLnnlJbpM0/vgMS', 1, 'testUser@test.com', 1),
(10016, 'testymctestface', '$2a$10$2l47H01ruQaMMBPA.OGjquRYwT4F8iSWqvk1g4w2RkZfxgxwjE50O', 1, 'testymctestface', 1),
(10017, 'red', '$2a$10$bDvI/eUDGLyUlqg0PH2NAu2KSyMTnFpXeQgcIZpDx5Jo/J1u2gBL6', 1, 'red', 1),
(10018, 'blue', '$2a$10$Wu3nIW/tRLYLKdt5KzxFPeQ00Wo2SM3naAKkbOXbTliBzcRF4SbyS', 1, 'blue', 1),
(10019, 'scrawnycoleman2', '$2a$10$0Qgr82dh4nG5T2MmPSwAIO54Eimcfq/cmNdu03WvOTB5AEXOVBGBe', 1, 'newrandomemail@email.com', 1),
(10020, 'demoChange', '$2a$10$08O.Wy45R0vtwxlev8UUvejWJjwA7hzHnzZJt2/Wx5.nvsayZNn0K', 1, 'demochange@demo.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_lessons`
--

CREATE TABLE `user_lessons` (
  `id` int(11) NOT NULL,
  `is_completed` tinyint(1) NOT NULL,
  `user_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_lessons`
--

INSERT INTO `user_lessons` (`id`, `is_completed`, `user_id`, `lesson_id`) VALUES
(1, 0, 1, 1),
(2, 0, 1, 5),
(3, 1, 1, 6),
(4, 0, 1, 4),
(5, 0, 2, 1),
(6, 1, 2, 3),
(7, 1, 2, 2),
(9, 0, 1, 2),
(10, 0, 1, 3),
(11, 0, 2, 4),
(15, 0, 10019, 1),
(16, 0, 10019, 1),
(17, 0, 10019, 1),
(18, 0, 10019, 1),
(19, 0, 10020, 1),
(20, 0, 10020, 1),
(21, 0, 3, 12),
(22, 0, 3, 12),
(23, 0, 3, 12),
(24, 0, 3, 33),
(25, 0, 3, 33),
(26, 0, 3, 33);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `role_name`) VALUES
(1, 'user'),
(2, 'author'),
(3, 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `answer_question_id` (`question_id`),
  ADD KEY `answer_type` (`answer_type_id`);

--
-- Indexes for table `answer_types`
--
ALTER TABLE `answer_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_comment_post_id` (`post_id`),
  ADD KEY `fk_comment_author_id` (`author_id`);

--
-- Indexes for table `forum_posts`
--
ALTER TABLE `forum_posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lesson_forum_posts` (`lesson_id`);

--
-- Indexes for table `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_language_id` (`language_id`);

--
-- Indexes for table `practicals`
--
ALTER TABLE `practicals`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lesson_practicals_id` (`lesson_id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_questions_lesson_id` (`lesson_id`);

--
-- Indexes for table `recommended_prerequisites`
--
ALTER TABLE `recommended_prerequisites`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lesson_id` (`lesson_id`),
  ADD KEY `fk_recommended_id` (`recommended_lesson_id`);

--
-- Indexes for table `solutions`
--
ALTER TABLE `solutions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_practical_solutions_id` (`practical_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_role_id` (`user_role_id`);

--
-- Indexes for table `user_lessons`
--
ALTER TABLE `user_lessons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_lessons_user_id` (`user_id`),
  ADD KEY `fk_user_lessons_lesson_id` (`lesson_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `answer_types`
--
ALTER TABLE `answer_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `forum_posts`
--
ALTER TABLE `forum_posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `languages`
--
ALTER TABLE `languages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lessons`
--
ALTER TABLE `lessons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `practicals`
--
ALTER TABLE `practicals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `recommended_prerequisites`
--
ALTER TABLE `recommended_prerequisites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `solutions`
--
ALTER TABLE `solutions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10021;

--
-- AUTO_INCREMENT for table `user_lessons`
--
ALTER TABLE `user_lessons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `answer_question_id` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`),
  ADD CONSTRAINT `answer_type` FOREIGN KEY (`answer_type_id`) REFERENCES `answer_types` (`id`);

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `fk_comment_author_id` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fk_comment_post_id` FOREIGN KEY (`post_id`) REFERENCES `forum_posts` (`id`);

--
-- Constraints for table `forum_posts`
--
ALTER TABLE `forum_posts`
  ADD CONSTRAINT `fk_lesson_forum_posts` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`);

--
-- Constraints for table `lessons`
--
ALTER TABLE `lessons`
  ADD CONSTRAINT `fk_language_id` FOREIGN KEY (`language_id`) REFERENCES `languages` (`id`);

--
-- Constraints for table `practicals`
--
ALTER TABLE `practicals`
  ADD CONSTRAINT `fk_lesson_practicals_id` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`);

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `fk_questions_lesson_id` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`);

--
-- Constraints for table `recommended_prerequisites`
--
ALTER TABLE `recommended_prerequisites`
  ADD CONSTRAINT `fk_lesson_id` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`),
  ADD CONSTRAINT `fk_recommended_id` FOREIGN KEY (`recommended_lesson_id`) REFERENCES `lessons` (`id`);

--
-- Constraints for table `solutions`
--
ALTER TABLE `solutions`
  ADD CONSTRAINT `fk_practical_solutions_id` FOREIGN KEY (`practical_id`) REFERENCES `practicals` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_user_role_id` FOREIGN KEY (`user_role_id`) REFERENCES `user_roles` (`id`);

--
-- Constraints for table `user_lessons`
--
ALTER TABLE `user_lessons`
  ADD CONSTRAINT `fk_user_lessons_lesson_id` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`),
  ADD CONSTRAINT `fk_user_lessons_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

