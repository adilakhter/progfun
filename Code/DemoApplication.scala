
/* If an object extends Application, then the body of the object is
   effectively a script. */

object DemoApplication extends Application {

  /*
   Warning (courtesy of Dean Wampler): 

   Extending Application runs the entire program in the constructor
   for the object, which prevents the JVM from performing JIT
   optimizations.

   For large applications, use a main() method instead of extending
   Application.
  */

  println("Hello, World!")
}
