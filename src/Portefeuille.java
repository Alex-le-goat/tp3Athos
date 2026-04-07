public class Portefeuille 
{
  private Cryptomonnaie monnaie;
  private double montant; // Soit le nombre de jetons
  private String proprietaire;

  public Portefeuille(Cryptomonnaie monnaie, double montant, String proprietaire){
	  this.monnaie      = monnaie;
	  this.montant      = montant;
	  this.proprietaire = proprietaire;
  }

  public boolean transfertDevise (Portefeuille destination, double montantJetons){
	  if (this.monnaie == destination.monnaie){
		  if (this.montant >= montantJetons){
			  this.montant = this.montant - montantJetons;
			  destination.montant = destination.montant + montantJetons;
			  return true;
		  }
	  }
	  return false;
  }

  public boolean achatDevise (double montantEuros){
	  if (montantEuros >= 0){
		  double jetons = montantEuros / this.monnaie.getValeurDeJeton();
		  this.montant = this.montant + jetons;
		  return true;
	  }
	  return false;
  }

  public boolean estProprietaire (String proprietaire){
		return (proprietaire.equals(this.proprietaire))?true:false;
  }

  public double valeurEnEuros(){
	  return this.montant * this.monnaie.getValeurDeJeton();
  }

  public String getProprietaire() {
	  return proprietaire;
  }

  public Cryptomonnaie getMonnaie() {
	  return monnaie;
  }

  public double getMontant() {
	  return montant;
  }

  @Override
  public String toString() {
	  return String.format("%10s",proprietaire) + " : "
		   + String.format("%10.1f", montant)   + " x " 
		   + this.monnaie.toString()            + " = "
		   + String.format("%10.1f", valeurEnEuros());
  }

}

