
public class Casa {
	
	public void getTomadaSala(TomadaDoisPinos tomadaDoisPinos) {
		if(tomadaDoisPinos != null) {
			tomadaDoisPinos.exibirTomarDoisPinos();
		}
	}
	
	public void getTomadaQuarto(TomadaTresPinos tomaTresPinos) {
		if(tomaTresPinos != null) {
			tomaTresPinos.exibirTomarTresPinos();
		}
	}

}
