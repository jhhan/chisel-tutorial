package TutorialProblems

import Chisel.testers.UnitTestRunners


object TutorialProblems extends UnitTestRunners {
  val list_of_tests = Array(
    "Accumulator"            -> (() => { new AccumulatorTests }),
    "LFSR16"                 -> (() => { new LFSR16Tests }),
    "SingleEvenFilter"       -> (() => { new SingleEvenFilterTests(16) }),
    "VecShiftRegister"       -> (() => { new VecShiftRegisterTests }),
    "VecShiftRegisterSimple" -> (() => { new VecShiftRegisterSimpleTests }),
    "VecShiftRegisterParam"  -> (() => { new VecShiftRegisterParamTests(8, 4) }),
    "Max2"                   -> (() => { new Max2Tests }),
    "MaxN"                   -> (() => { new MaxNTests(8, 16) }),
    "Adder"                  -> (() => { new AdderTests(8) }),
    "DynamicMemorySearch"    -> (() => { new DynamicMemorySearchTests(8, 4) }),
    "RealGCD"                -> (() => { new RealGCDTests }),
    "Mux2"                   -> (() => { new Mux2Tests }),
    "Mux4"                   -> (() => { new Mux4Tests }),
    "Memo"                   -> (() => { new MemoTests }),
    "Mul"                    -> (() => { new MulTests }),
    "Counter"                -> (() => { new CounterTest }),
    "VendingMachine"         -> (() => { new VendingMachineTests }),
    "VendingMachineSwitch"   -> (() => { new VendingMachineSwitchTests })
  ).toMap

  def main(args: Array[String]): Unit = {
    val to_call = if( args.length > 0) args else list_of_tests.keys.toArray

    for( arg <- to_call ) {
      if (list_of_tests.contains(arg)) {
        execute( list_of_tests(arg)() )
      }
      else {
        println(s"Error: $arg not found in list of tests")
        println("option\n"+ list_of_tests.keys.toList.sorted.mkString(", "))
      }
    }
  }
}


