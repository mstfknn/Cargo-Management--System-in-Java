package Package;

import java.io.IOException;
import java.util.*;


public class Test {

	public static void main(String[] args) throws IOException {
		
		Container container=new Container();
		Management management= new Management();
		System.out.println(".............       ...........  ...     ...  ...........       ..............");
		System.out.println(".............       ...........  ....    ...  ...........       ..............");
		System.out.println(".............       ...          .....   ...  ...               ..............");
		System.out.println(".............       ...          ... ..  ...  ...  ......       ..............");
		System.out.println(".............       ...          ...  .. ...  ...  ......       ..............");
		System.out.println(".............       ...          ...   .....  ...     ...       ..............");
		System.out.println(".............       ...........  ...    ....  ...........       ..............");
		System.out.println(".............       ...........  ...     ...  ...........       ..............");
		Management.Screen();
		management.addContainer(new Container("izmir",40,"35izm00", (Container.IDIzmir),false));
		management.addContainer(new Container("izmir",20,"35izm01", (Container.IDIzmir),false));
		management.addContainer(new Container("ankara",40,"06ank00", (Container.IDAnkara),false));
		management.addContainer(new Container("ankara",20,"06ank01", (Container.IDAnkara),false));
		while(true){
		System.out.println();
		System.out.print("Commands > ");
		Management.Command();
		
		}
		
		
	}

}
