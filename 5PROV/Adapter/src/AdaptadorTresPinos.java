
public class AdaptadorTresPinos extends TomadaDoisPinos {
	
	private TomadaTresPinos tomadaTresPinos;
	
	public AdaptadorTresPinos(TomadaTresPinos tomadaTresPinos) {
		this.tomadaTresPinos = tomadaTresPinos;
	}

	@Override
	public void exibirTomarDoisPinos() {
		tomadaTresPinos.exibirTomarTresPinos();
	}
}
