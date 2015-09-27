package Package;
public class NextDay {

	static int[] cargoMax = new int[100];//It stored cargoes from bigger to smaller in this array.
	static int[] cargoSearch = new int [100];//It stored cargoes of smaller than search in this array.
	static int[][] container = new int[100][100];//It is stored best possibilities for best fit.
	static int[] containerTry = new int[10000];//It is stored all possibilities container fit.
	static int[][] cargoTry = new int[10000][100];//It is stored cargoes of all possibilities container fit.

	public static void Bestfit(int[] cargo, int[] containerVolume){
		int containerTryNo=0;//It is counter of contaierTyr array
		int cargoTryNo=0;//It is counter of cargoTyr array
		int max=0;//It used to rank cargo from bigger to smaller.
		int k=-1;//We use to reset cargo and k variable is used to send cargoes to cargoMax[] don't see again.
		int searchNo=0;//It is counter of cargoSearch array.
		int finishedTry = 0;//It is determined a cargoes and it is tried all possibilities to keep constant the cargoes.
		int search=-1;//It is used to all cargoes for search.
		int x=0;//x variable used to new possibilities.
		int a=0;//x variable used to new possibilities.
		int i = 1;//x variable used to new possibilities.
		int y = 1;//x variable used to new possibilities.
		int cargoSum=-1;//this is sum of all cargoes and used variables searched.
		int cargolength=Cargo.numberofCargoes;//It is cargo length.

		max=0;
		boolean flag=false;
		while(true){
			if(Management.CityHolder + Management.counter!=0)
			{
				cargoSum=0;
				for (int j = 0; j < Cargo.numberofCargoes; j++) //That for loop search maximum variable.
				{
					cargoSum+=cargo[j];
				}
				if(cargoSum<=20 && cargoSum!=0 && !flag)//That for loop calculate total container volumes.
				{
					for (int j = 0; j < Cargo.numberofCargoes; j++) {
						container[1][j]=cargo[j];
					}	
					a=1;
					a++;
					for (int j = 0; j < Cargo.numberofCargoes; j++) {
						cargo[j]=0;
					}
					break;
				}
				flag=true;
				cargoSum=-1;
				for (int m = 0; m < Cargo.numberofCargoes; m++) {	
					max = 0;
					for (int j = 0; j < Cargo.numberofCargoes; j++) {	
						if(cargo[j]>max){
							k=j;
							max = Math.max(cargo[j], max);
						}
					}
					cargoMax[m] = max;
					try{
						cargo[k]=0;//All cargoes equals zero.
					}
					catch(Exception e){

					}
				}
				for (int j = 0; j < Cargo.numberofCargoes; j++) {//cargo equals cargoMax[].
					cargo[j]=cargoMax[j];
				}
				searchNo=0;
				search = -1;
				for (i = 0; i < Cargo.numberofCargoes; i++) {
					cargolength=Cargo.numberofCargoes;
					searchNo=0;
					if(search==0)
						break;
					search=containerVolume[a]-cargoMax[i];//cargoMax[i] is the cargo to used first. search variable is to search volume of cargoes.
					cargoTry[containerTryNo][cargoTryNo]=cargoMax[i];//It is stored cargoes of all possibilities container fit.
					cargoTryNo++;
					for (int j = y; j < Cargo.numberofCargoes; j++) {//y variable is used for new posibilities.
						if(cargoMax[j]<=search && cargoMax[j]!=0){
							cargoSearch[searchNo]=cargoMax[j];//It is stored volume of cargoes which search
							searchNo++;
						}
					}

					do{

						for (int z = x; z < Cargo.numberofCargoes; z++) {//y variable is used for new posibilities.
							if(cargoSearch[z]<=search && cargoSearch

									[z]!=0){
								search = search - cargoSearch[z];
								cargoTry[containerTryNo]

										[cargoTryNo]=cargoSearch[z];
								cargoTryNo++;
								cargoSearch[z]=0;
								if(search==0 ){
									break;
								}
							}
						}
						if(search==0){//if search is finished , all loop finished and start new containers search
							containerTry

							[containerTryNo]=containerVolume[a]-search;
							containerTryNo++;
							y++;
							x=0;
							cargoTryNo=0;
							break;
						}
						else{// else all possibilities try again.
							finishedTry++;
							containerTry

							[containerTryNo]=containerVolume[a]-search;
							containerTryNo++;
							if(finishedTry!=cargolength-1){
								i--;
							}
							else{
								y++;
								finishedTry=0;
								x=-1;
								cargolength--;
							}
							x++;
							cargoTryNo=0;
							break;
						}

					}while(true);
				}	
				max = 0;
				k=0;
				for (int l = 0; l < containerTryNo; l++) {	//containerTry equals zero.
					if(containerTry[l]>max)
					{
						max = Math.max(containerTry[l], max);
						k=l;
					}
					containerTry[l]=0;
				}

				for (int j = 0; j < Cargo.numberofCargoes; j++) {//cargo equals zero.
					container[a][j]=cargoTry[k][j];
					for (int j2 = 0; j2 < Cargo.numberofCargoes; j2++) {
						if(cargo[j2]==cargoTry[k][j])
						{
							cargo[j2]=0;
							break;
						}
					}
					for (int j2 = 0; j2 < Cargo.numberofCargoes; j2++) {//cargoMax equals zero.
						cargoMax[j2]=0;
					}
				}

				for (int j2 = 0; j2 < Cargo.numberofCargoes; j2++) {//cargoSearch equals zero.
					cargoSearch[j2]=0;
				}

				for (int l = 0; l < containerTryNo; l++) {	
					for (int j = 0; j < cargoTry[l].length; j++) {
						cargoTry[l][j] = 0;
					}
				}

				containerTryNo=0;

				a++;
				y=1;
			}
			if(a>=Management.CityHolder)//That if container hiring
			{
				cargoSum=0;
				for (int j = 0; j < Cargo.numberofCargoes; j++) 
				{
					cargoSum+=cargo[j];
				}

				if(cargoSum!=0 && cargoSum<=20)
				{
					containerVolume[Management.CityHolder + Management.counter]=20;
					Management.counter++;
				}
				else if (cargoSum!=0)
				{
					containerVolume[Management.CityHolder + Management.counter]=40;
					Management.counter++;
				}
				else
					break;
			}
		}

		for (int j = 0; j < Management.counter + Management.CityHolder; j++) {
			System.out.println();
			System.out.print(containerVolume[j]+"     ");
			for (int j2 = 0; j2 < Cargo.numberofCargoes; j2++) {
				if(container[j][j2]!=0)
					System.out.print(container[j][j2]+" ");
			}	
		}
	}
}

