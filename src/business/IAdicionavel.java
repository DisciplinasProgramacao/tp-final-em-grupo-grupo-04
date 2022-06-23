package business;

import java.io.Serializable;
//herança serializable 
public interface IAdicionavel extends Serializable{

void inserirAdicionais(TipoDeAcrescimo tipoDeAcrescimo);
  
}