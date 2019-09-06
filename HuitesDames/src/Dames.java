import javax.swing.JOptionPane;
/**
 * 
 * @author Mamadou Barri, SIM. 2018-03-06
 * Le problème des huites dames
 */
public class Dames {
	static int n;//Déclarer une variable statique qui est accessible dans toutes les méthodes de la classe
	//static int debut=0;
	public static void main(String[] args) {
		do {
			n = Integer.parseInt(JOptionPane.showInputDialog("Entrez les dimensions de n! (n<>2,3)"));
		}while(n==3 || n==2);//Pas de solutions pour n=2,3
		int mat[][] = new int [n][n];
		//Vérifier s'il existe une solution
		placer(mat,0);
		System.out.print("Solution possible pour une dimension de n = " + n + ": " + "\n");
		afficher(mat);
		afficherLogo();
	}

	//La methode principale recursive qui s'occupe du placement
	static boolean placer(int mat[][], int lig) {
		//Cas principal lorsqu'on a placé n reines
		if(lig==n) {
			//debut++;
			return true;
		}else {
			//Il reste des reines à placer
			for(int col = 0; col<n;col++) {
				//Vérifier si la case est libre 
				if(caseLibre(mat,lig,col)) {
					//oui-->placer reine
					mat[lig][col] = 1;
					if(placer(mat,lig+1)) //Retourner vrai si on peut placer la suivante sinon faux...
					{
						return true;
					}
				}
				mat[lig][col]=0;//Sinon on remet 0 dans la case vu qu'on ne peut pas placer la suivante
			}
			return false;// si la place n'a pas été trouvée
		}

	}
	//La méthode qui vérifie si on peut placer la reine à cette case
	static boolean caseLibre(int mat[][],int lig,int col) {
		//Verifier si la ligne est libre
		for(int i= 0 ; i<mat.length;i++) {
			if(mat[lig][i] == 1) {
				return false;
			}
		}
		//verifier si la colonne est libre
		for(int j = 0; j<mat.length;j++) {
			if(mat[j][col] == 1) {
				return false;
			}
		}
		//Verifier les diagonales:droit,gauche en bas et en haut
		for(int k=lig,j=col;j<mat.length && k<mat.length;k++,j++) {
			if(mat[k][j] ==1) {
				return false;
			}
		}
		for(int k=lig,j=col;k>=0 && j<mat.length;k--,j++) {
			if(mat[k][j]==1) {
				return false;
			}
		}
		for(int k=lig,j=col;k>=0 && j>=0;k--,j--) {
			if(mat[k][j]==1) {
				return false;
			}
		}
		for(int k=lig,j=col;k<mat.length && j >=0;k++,j--) {
			if(mat[k][j] == 1) {
				return false;
			}
		}
		return true; // ---> si la case est libre apres toutes les verifications
	}
	//La méthode qui affiche notre matrice
	public static void afficher(int mat[][]) {
		afficherBordures();
		//afficher la matrice
		for(int lig =0; lig<mat.length;lig++) {
			System.out.print("| ");
			for(int col=0;col<mat.length;col++) {
				if(mat[lig][col] == 1) {
					System.out.print("[X]");
				}else {
					System.out.print("[ ]");
				}
			}
			System.out.print(" |");
			System.out.println("");
		}
		afficherBordures();
	}
	//Les bordures de la matrice
	public static void afficherBordures() {
		System.out.print("  ");
		for(int k=0; k<n;k++) {
			System.out.print("---");
		}
		System.out.println("");
	}
	//Identification
	public static void afficherLogo() {
		System.out.print("Fait par Mamadou Barri ©");
	}

}
