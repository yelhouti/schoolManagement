package test

import enums.ServiceTG

object EnumTest {
  def main(args: Array[String]) {
    //println(ServiceTG.HalfTransportAndGarde.id)
    println(ServiceTG.apply(1))
  }
}