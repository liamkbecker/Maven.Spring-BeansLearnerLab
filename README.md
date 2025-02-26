# Bean Flavored com.example.demo.general.Learner Lab
* **Objective** - to register a `com.example.demo.general.Classroom` bean which _mediates_ a _composite_ `com.example.demo.general.Students` and `com.example.demo.general.Instructors` bean reference.
* **Purpose** - to demonstrate the use of
	* Bean registration
	* Dependency Injection
	* IOC Container
	* `AnnotationConfigApplicationContext`
	* Annotations
		* `@Bean`
		* `@DependsOn`
		* `@Autowired`
		* `@PostConstruct`
		* `@Config`
		* `@SpringBootTest`
		* `@Qualifier`


## Developmental Notes
* Do NOT clone this repository until completing `Part 0.0`
* You may structure this project and the packaging how you please, however keep in mind that `@Configuration` scans from current directory down.
* Until `Part 10`, this project is nearly identical to the `LearnerLab` completed in the past.

### Part 0.0 - Generating Project
* Navigate to [start.spring.io](https://start.spring.io/)
* In the `Search for Dependencies` input box search for 
	* `DevTools`
	* `Web`
* Select `Generate Project`
* After the project has completed downloading, navigate to the download directory and unzip the project folder.
* At the root directory of the project, clone this repository.
* Move all files from the `demo` project generated by `start.spring.io`, into the newly cloned `learnerlab` folder.
* Open the project via its `pom.xml` from IntelliJ > File > Open
	* Be sure to `Open as Project` when prompted 

### Part 1.0 - Create `com.example.demo.general.Person` Class
* Create a `com.example.demo.general.Person` class.
	* The class should declare a `final` field named `id` of type `long`.
	* The class should declare a field named `name` of type `String`.	
	* `com.example.demo.general.Person` constructor should have a parameter of type `Long id, String name` which sets each of the fields to their respective value.
	* The class should define a `getId()` method which returns the `com.example.demo.general.Person` object's `id` field.
	* The class should define a `getName()` method which returns the `com.example.demo.general.Person` object's `name` field.
	* The class should define a `setName()` method which sets the `com.example.demo.general.Person` object's `name` field.

-
### Part 2.0 - Create `com.example.demo.general.Learner` Interface
* Create a `com.example.demo.general.Learner` interface.
	* `com.example.demo.general.Learner` should declare one method signature:
		* Method name: `learn`
		* Method parameters: `double numberOfHours`
		* Method return-type: `void`

-
### Part 3.0 - Create `com.example.demo.general.Student` Class
* Create a `com.example.demo.general.Student` class such that:
	* `com.example.demo.general.Student` is a subclass of `com.example.demo.general.Person`
	* `com.example.demo.general.Student` implements the `com.example.demo.general.Learner` interface
	* `com.example.demo.general.Student` should have an instance variable `totalStudyTime` of type `double`
	* `com.example.demo.general.Student` should have a concrete implementation of the `learn` method which increments the `totalStudyTime` variable by the specified `numberOfHours` argument.
	* `com.example.demo.general.Student` should have a `getTotalStudyTime()` method which returns the `totalStudyTime` instance variable.


-
### Part 4.0 - Create `com.example.demo.general.Teacher` Interface
* Create a `com.example.demo.general.Teacher` interface.
	* `com.example.demo.general.Teacher` should declare a `teach` method signature:
		* Method name: `teach`
		* Method parameters:
			* `com.example.demo.general.Learner learner`
			* `double numberOfHours`
		* Method return-type: `void` 

	* `com.example.demo.general.Teacher` should declare a `lecture` method signature:
		* Method name: `lecture`
		* Method parameters:
			* `Iterable<? extends com.example.demo.general.Learner> learners`
			* `double numberOfHours`
		* Method return-type: `void`

		
-
### Part 5.0 - Create `com.example.demo.general.Instructor` Class
* Create an `com.example.demo.general.Instructor` class such that:
	* `com.example.demo.general.Instructor` is a subclass of `com.example.demo.general.Person`
	* `com.example.demo.general.Instructor` implements the `com.example.demo.general.Teacher` interface
	* `com.example.demo.general.Instructor` should have a concrete implementation of the `teach` method which invokes the `learn` method on the specified `com.example.demo.general.Learner` object.
	* `com.example.demo.general.Instructor` should have a concrete implementation of the `lecture` method which invokes the `learn` method on each of the elements in the specified array of `com.example.demo.general.Learner` objects.
		* `numberOfHours` should be evenly split amongst the learners.
			* `double numberOfHoursPerLearner = numberOfHours / learners.length;`

### Part 6.0 - Create `com.example.demo.general.People`
* Create an abstract `com.example.demo.general.People` class
	* The class signature should be parameterized with `PersonType` such that `PersonType` is a sub class of `com.example.demo.general.Person`.
	* The class should implement `Iterable` of type `PersonType`.
	* Upon construction `com.example.demo.general.People` should consume a `List` of `PersonType` and set it to a respective `personList` field.
	* The class should define a constructor which consumes a variable number of `PersonType` objects and sets the `personList` field respectively.
	* The class should define a method named `add` which adds a `PersonType` to the `personList`.
	* The class should define a method named `remove` which removes a `PersonType` from the `personList`.
	* The class should define a method named `size` which returns the size of `personList`.
	* The class should define a method named `clear` which clears our `personList` field.
	* The class should define a method named `addAll` which adds an `Iterable` of `PersonType` objects to the composite `personList`.
		* This method will **NOT** take an argument of `Collection<PersonType>`
	* The class should define a method named `findById` which makes use of a `long id` parameter to return a `PersonType` object with the respective `id` field.
	* The class should define a method named `findAll` which returns the composite `personList`.


-
### Part 7.0 - Create `com.example.demo.general.Students` 
* Create a `com.example.demo.general.Students` class.
	* The class should be a subclass of `com.example.demo.general.People` of parameterized type `com.example.demo.general.Student`.
	* The class should consume a variable number of `com.example.demo.general.Student` objects upon construction and pass them to the super constructor.

-
### Part 8.0 - Create `com.example.demo.general.Instructors` 
* Create a `com.example.demo.general.Instructors` class.
	* The class should be a subclass of `com.example.demo.general.People` of parameterized type `com.example.demo.general.Instructor`.
	* The class should consume a variable number of `com.example.demo.general.Instructor` objects upon construction and pass them to the super constructor.



-
### Part 9.0 - Create `com.example.demo.general.Classroom`
* Create a `com.example.demo.general.Classroom` class.
	* The class should consume and set composite reference to an `com.example.demo.general.Instructors` and `com.example.demo.general.Students` object upon construction
	* The class should define a method `hostLecture` which makes use of a `com.example.demo.general.Teacher teacher, double numberOfHours` parameter to host a `lecture` to the composite `personList` field in the `students` reference.
	

-
## Part 10.0 - Creating `Configuration` classes
* Each of the following `Config` classes should have a class-signature annotation of `@Configuration`
	* this annotation tells spring to scan for `@Bean` definitions within the scope of the class, and register them to the [IOC Container](https://www.tutorialspoint.com/spring/spring_ioc_containers.htm) for `Inject` and `Autowire` use later.
* com.example.demo.general.Classroom should define getters for each of its fields.

### Developmental Notes
* `@Autowired`
	* injects bean by type
	* can be used alone.
	* If is used alone, it will be wired by type
	* If more than one bean of same type are declared in the container `@Autowired` does not know which beans to use for injection.


* `@Qualifier`
	* injects bean by specified name
	* supports fields, setter, constructors and multi-argument methods injection
	* together with `@Autowired`, clarifies which beans to be wired by specifying the bean name (wired by name)

<img src = "https://www.logicbig.com/tutorials/spring-framework/spring-core/javaconfig-methods-inter-dependency/images/bean-params.png">


-
### Part 10.1 - Create `StudentConfig`
* **Note:** The creation of this class will demonstrate an implementation of _bean registration_ in Spring.
* The class should define a method named `currentStudents()` which returns a `com.example.demo.general.Students` representative of the current cohort of students.
	* the method should be annotated with `@Bean(name = "students")`
		* this ensures the Spring container registers the bean with the respective name.
		* a `@Bean` whose `name` attribute is not specified defaults to the name of the method it is annotating.
* The class should define a bean named `previousStudents()` which returns a `com.example.demo.general.Students` representative of the previous cohort of students.	

-
### Part 10.2 - Create `InstructorsConfig`
* The class should define a bean named `tcUsaInstructors()` which returns an `com.example.demo.general.Instructors` representative of the Tech Connect USA instructors.
* The class should define a bean named `tcUkInstructors()` which returns an `com.example.demo.general.Instructors` representative of the Tech Connect UK instructors.
* The class should define a bean named `instructors` which returns all `com.example.demo.general.Instructors` employed at ZipCodeWilmington
	* annotate this bean with `@Primary`
		* this ensures Spring will inject this bean in the case that an `Autowire` annotation is not supplied with a `Qualifier` annotation



-
### Part 10.3 - Create `ClassroomConfig`
* The class should define a bean named `currentCohort()` which returns a `com.example.demo.general.Classroom` object whose dependencies are `instructors` and `students`
* The class should define a bean named `previousCohort()` which returns an `com.example.demo.general.Classroom` object whose dependencies are `instructors` and `previousStudents`
* **Note:** [it is sometimes useful](https://www.boraji.com/spring-dependson-annotation-example) (although not always necessary) to use the `@DependsOn` annotation to help the Spring framework and other readers of the code to understand what order beans should be executed.
	* `@DependsOn({"instructors", "students"})`

	


-
## Part 11.0 - Test `Config` classes
* Each of the following `Test` classes should be annotated with
	* `@RunWith(SpringRunner.class)`
		* enforces which strategy `junit` should use to run tests
	* `@SpringBootTest`
		* indicates that this class is a Spring Boot test class
		* provides support to scan for a `ContextConfiguration` that tells the test class how to load the `ApplicationContext`.
		* If no `ContextConfiguration` classes are specified as a parameter to the `@SpringBootTest` annotation, the default behavior is to load the `ApplicationContext` by scanning for a `@SpringBootConfiguration` annotation on a class in the package root.
* Each bean can be injected into the class scope using `@Autowired` along with `@Qualifier(name = "beanname")`



-
### Part 11.1 - Test `StudentConfig` Class
* Create a `TestStudentConfig` class in the `test` package.
* The class should ensure that each `Bean` in the `StudentConfig` class is configured as expected.
* **Tip:** You can use the `toString` method to get a representation of the aggregate state of any `com.example.demo.general.People` object.


-
### Part 11.2 - Test `InstructorConfig` Class
* Create a `TestInstructorConfig` class in the `test` package.
* The class should ensure that each `Bean` in the `TestInstructorConfig` class is configured as expected.


-
### Part 11.3 - Test `ClassroomConfig` Class
* Create a `TestClassroomConfig` class in the `test` package.
* The class should ensure that each `Bean` in the `TestClassroomConfig` class is configured as expected.







## Part 11.0 - Using `@Component`
* Annotating a class signature with `@Component` allows Spring to register the class as a `Bean` implicitly.


-
### Part 11.1 - Create `Alumni` Class
* Create an `Alumni` component which autowires `com.example.demo.general.Students` of the previous cohort and `com.example.demo.general.Instructors`
* Create an `executeBootcamp` method which teaches each `com.example.demo.general.Student` in the composite `com.example.demo.general.Students` a `totalNumberOfHours` of `1200`.
	* Annotate this method with `@PostConstruct`
		* denotes that this method must be executed before the class is put into an IoC container
* Create a getter for each of the fields.

-
### Part 11.2 - Test `Alumni` Class
* Write a test class which ensures that each `com.example.demo.general.Student` in the `Alumni` class has been taught `1200` hours upon injection of the `Alumni` dependency.
* Ensure the `numberOfHoursTaught` has been evenly distributed amongst each of the instructors.

* **Tip:** How to derive `numberOfHoursTaught` dynamically
```java
int numberOfInstructors = instructors.size();
int numberOfStudents = students.size();
double numberOfHoursToTeachEachStudent = 1200;
double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
```
