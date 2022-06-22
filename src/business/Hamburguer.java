package business;

public class Hamburguer extends Comida implements IAdicionavel {
	
	private static final double PRECO_BASE_HAMBURGUER = 12;
	private boolean paoArtesanal;
	private static final double PRECO_DO_PAO_ARTESANAL = 2;

	public Hamburguer(boolean paoArtesanal) {
		super();
		this.setPrecoBase(Hamburguer.PRECO_BASE_HAMBURGUER);
		this.setPaoArtesanal(paoArtesanal);
	}

	public boolean isPaoArtesanal() {
		return paoArtesanal;
	}

	public void setPaoArtesanal(boolean paoArtesanal) {
		if (paoArtesanal) {
			this.setPrecoBase(this.getPrecoBase() + Hamburguer.PRECO_DO_PAO_ARTESANAL);
		}
		this.paoArtesanal = paoArtesanal;
	}

	public static double getPrecoBaseHamburguer() {
		return PRECO_BASE_HAMBURGUER;
	}

	@Override
	public void inserirAdicionais(TipoDeAcrescimo tipoDeAcrescimo) {
		if (!tipoDeAcrescimo.equals(null)) {
			this.setPrecoBase(this.getPrecoBase() + tipoDeAcrescimo.preco);
			this.extrato.add(tipoDeAcrescimo.toString());
		}

	}

	@Override
	public String toString() {
		return "(" + this.getId() + ")" + "Hamburguer " + this.getExtrato();
	}

}
