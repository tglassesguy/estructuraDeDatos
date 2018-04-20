package mundo.test;

import java.util.ArrayList;
import java.util.List;

import mundo.db.Servicio;
import mundo.facade.Facade;

public class Test {

	Servicio servicio;
	Facade facade;
	public Test()
	{
		servicio = new Servicio();
		facade = new Facade();
		
	}
	public static void main(String[] args) {
		new Test();
	}

}
