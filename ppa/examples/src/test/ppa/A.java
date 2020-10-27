package test.ppa;

class A extends B {

  public boolean methodA() {
    int index = 0;
    C varC = new D();
    E varE = new E();
    varC.field1 = index;
    varC.method2(varC.field1,varE);
    methodB(index,varC.field2);

    return varE.checkThis();
  }

  private void methodB(int param1, F param2) {

  }

  private void methodB(G param1, H param2) {

  }

}
