public class AdapterTurkey implements IDuck
{
				private Turkey turkey;
				public AdapterTurkey(Turkey t)
				{
								turkey = t;
				}
				public void quack()
				{
								System.out.println("AdapterTurkey uses TurkeyAction()");
								turkey.TurkeyAction();
				}
}
