Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?

In the House class I overloaded the constructor to allow quick actions in creating a default house for using the functions. I overloaded `moveIn()` to add flexibility, user may want to just quickly move someone in by name without specifying other details required to create a Student object.

In the Library class I overloaded `containsTitle()` and `isAvailable()` because it’s helpful for users who might not remember or type the full "Title by Author" string perfectly. By allowing the methods to accept separate title and author parameters, the system can reconstruct the full string and reduce possibilities of errors.

In the Cafe class I overloaded the constructor to allow quick actions in creating a default cafe for using the functions. I also overloaded `sellCoffee()` twice to allow for both default and custom coffee orders. The default `sellCoffee()` method is useful for customers who just want a quick, regular cup. The other version that takes double parameters for coffee size, sugar, and cream lets users customize their drink exactly to their preferences and make sure that user-specified numbers would work.

- What worked, what didn't, what advice would you give someone taking this course in the future?

I had a hard time figuring out when does the function run to which if statement in my `goToFloor()` overriding the one in the Building class. Furthermore, understanding which variable name is which value is important, as it could refer to the building's own metrics or the user specified number for an action. An advice would be to run and go through the output carefully, as sometimes things all run and prints but were wrong.
