package utilitaire;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class Daty 
{
	public static java.sql.Date convertir(int taona, int volana, int andro)
	{
		int taonaIzy = taona-1900;
		int volanaIzy = volana-1;
		return new java.sql.Date(taonaIzy, volanaIzy, andro);
	}
	
	public static String corrigeDate(String str)
	{
		String valiny = str;
		if(str!=null)
		{
			valiny = valiny.replace('/', '-');
			valiny = valiny.replace(':', '-');
			valiny = valiny.replace('.', '-');
			valiny = valiny.replace(' ', '-');
			valiny = supressionDoublon(valiny, '-');
			valiny = supressionDoublon(valiny, ' ');
			String[] split = valiny.split("-");
			if(split!=null && split.length==3)
			{
				int annee = Integer.parseInt(split[0]);
				int mois = Integer.parseInt(split[1]);
				int date = Integer.parseInt(split[2]);
				if(annee<date)
				{
					valiny = Integer.toString(date)+"-"+Integer.toString(mois)+"-"+Integer.toString(annee);
				}
				else
				{
					valiny = Integer.toString(annee)+"-"+Integer.toString(mois)+"-"+Integer.toString(date);
				}
			}
		}
		return valiny;
	}
	
	public static String corrigeHeure(String str)
	{
		String valiny = str;
		if(str!=null)
		{
			valiny= valiny.toLowerCase();
			int indAM = valiny.indexOf("am");
			int indPM = valiny.indexOf("pm");
			boolean pm = false;
			if(indAM>0)
			{
				valiny=valiny.substring(0, indAM);
			}
			else if(indPM>0)
			{
				valiny=valiny.substring(0, indPM);
				pm=true;
			}
			
			valiny = valiny.replace(' ', ':');
			valiny = valiny.replace('.', ':');
			valiny = valiny.replace('/', ':');
			valiny = valiny.replace('-', ':');
			valiny = valiny.replace('h', ':');
			valiny = valiny.replace('m', ':');
			valiny = valiny.replace("s", "");
			valiny = valiny.replace('H', ':');
			valiny = valiny.replace('M', ':');
			valiny = valiny.replace("S", "");
			
			valiny = valiny.replace(" ", "");
			valiny = Daty.supressionDoublon(valiny, ':');
			String[] split = valiny.split(":");
			int hInt = 0;
			int mInt = 0;
			int sInt = 0;
			if(split!=null && split.length==1)
			{
				hInt = Integer.parseInt(split[0]);
				if((pm && hInt==12 && mInt==0) || (pm && hInt<12))
				{
					hInt+=12;
				}
			}
			if(split!=null && split.length==2)
			{
				hInt = Integer.parseInt(split[0]);
				mInt = Integer.parseInt(split[1]);
				if((pm && hInt==12 && mInt==0) || (pm && hInt<12))
				{
					hInt+=12;
				}
			}
			else if(split!=null && split.length==3)
			{
				hInt = Integer.parseInt(split[0]);
				mInt = Integer.parseInt(split[1]);
				sInt = Integer.parseInt(split[2]);
				if((pm && hInt==12 && mInt==0) || (pm && hInt<12))
				{
					hInt+=12;
				}
			}
			
			valiny = Integer.toString(hInt)+":"+Integer.toString(mInt)+":"+Integer.toString(sInt);
		}
		return valiny;
	}
	
	public static String supressionDoublon(String str, char doublon)
	{
		if(str!=null)
		{
			int i=0;
			for(i=0; i<str.length()-1; i++)
			{
				if(str.charAt(i)==doublon && str.charAt(i+1)==doublon)
				{
					String temp1 = str.substring(0, i);
					String temp2 = str.substring(i+1);
					str = temp1+temp2;
					str = Daty.supressionDoublon(str, doublon);
				}
			}
		}
		return str;
	}
	
	public static Time stringToTime(String str)
	{
		return Time.valueOf(Daty.corrigeHeure(str));
	}
	
	public static java.sql.Date convertir(String date) throws Exception
	{
		java.sql.Date valiny = java.sql.Date.valueOf(Daty.corrigeDate(date));
		return valiny;
	}
	
	/*public static java.sql.Timestamp convertirHeure(String date) throws Exception
	{
		java.sql.Timestamp valiny = null;
		String[] split1 = null;
		
		if(date.indexOf("-")<0 && date.indexOf("/")<0)
		{
			throw new Exception("Ce n'est pas une date valide");
		}
		else if(date.indexOf("-")>=0)
		{
			split1 = date.split("-");
		}
		else if(date.indexOf("/")>=0)
		{
			split1 = date.split("/");
		}
		if(split1!=null && split1.length==3)
		{
			int annee = Integer.parseInt(split1[0]);
			int mois = Integer.parseInt(split1[1]);
			int jour = Integer.parseInt(split1[2]);
			if(annee<jour)
			{
				jour-=1900;
				mois-=1;
				valiny = new java.sql.Date(jour, mois, annee);
			}
			else
			{
				annee-=1900;
				mois-=1;
				valiny = new java.sql.Date(annee, mois,jour);
			}
		}
		return valiny;
	}*/
	
	public static java.sql.Date getDatySQLAndroany() throws Exception
	{
		Calendar cal=Calendar.getInstance();
		java.util.Date d= cal.getTime();
		return new java.sql.Date(d.getYear(),d.getMonth(),d.getDate());
	}
	
	public static java.sql.Timestamp getDatyTimesTampAndroany() throws Exception
	{
		return new Timestamp(Calendar.getInstance().getTime().getTime());
	}
	
	public static java.sql.Time getDatyTime() throws Exception
	{
		return new java.sql.Time(Calendar.getInstance().getTime().getTime());
	}
	
	public static long differenceAbsolueEnJour(Timestamp vaovao, Timestamp taloha)
	{
		 return Math.abs((vaovao.getTime() - taloha.getTime())/(24 * 60 * 60 * 1000));
	}
	
	public static long differenceEnJour(Timestamp vaovao, Timestamp taloha)
	{
		 return (vaovao.getTime() - taloha.getTime())/(24 * 60 * 60 * 1000);
	}
	
	public static int verificationMois(String mois) throws Exception
	{
		int moisInt = 0;
		try
		{
			moisInt = Integer.parseInt(mois);
			if(moisInt<=0 || moisInt>12)
			{
				throw new Exception("Mois invalide");
			}
		}catch (Exception excMois)
		{
			throw new Exception("Mois invalide");
		}
		return moisInt;
	}
	
	public static int verificationAnnee(String annee) throws Exception
	{
		int anneeInt = 0;
		try
		{
			anneeInt = Integer.parseInt(annee);
			if(anneeInt<=0)
			{
				throw new Exception("Annee invalide");
			}
		}catch (Exception excAnne)
		{
			throw new Exception("Annee invalide");
		}
		return anneeInt;
	}
	
	public static int nombreJour(int moisInt, int anneeInt) throws Exception
	{
		int valiny = 0;
		
		if(moisInt == 1 || moisInt == 3 || moisInt == 5 || moisInt == 7 || moisInt == 8 || moisInt == 10 || moisInt == 12)
		{
			valiny = 31;
		}
		else if(moisInt == 4 || moisInt == 6 || moisInt == 9 || moisInt == 11)
		{
			valiny = 30;
		}
		else if(moisInt==2)
		{
			int mod = anneeInt%4;
			if(mod==0)
			{
				valiny = 29;
			}
			else
			{
				valiny = 28;
			}
		}
		else
		{
			throw new Exception("Mois invalide");
		}
		return valiny;
	}
}
