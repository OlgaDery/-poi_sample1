/**
 * 
 */
package ejb;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author Olga
 *
 */
@Singleton
@LocalBean
@Startup
public class FiltersEJB {

	/**
	 * 
	 */
	private final Logger log = LoggerFactory.getLogger(getClass());
	 
	public static String []  district = {
			 "Achitskiy", "Alapayevsk", "Alapayevsky", "Artemovsky", "Artinskiy", "Azbest", "Baykalovskiy",
			 "Beloyarskiy", "Berezovskiy", "Bogdanovichskiy", "Garinskiy", "Prigorodniy", "Irbit", "Irbitskiy",
			 "Ivdel", "Kachkanar", "Kamenskiy", "Kamensk-Uralsky", "Kamishlov", "Kamishlovskiy", "Karpinsk",
			 "Kirovgrad", "Krasnoturyinsk", "Krasnoufimsk", "Krasnoufimskiy", "Krasnouralsk", "Kushva",
			 "Lesnoy", "Nevyansky", "Nizhneserginskiy", "Nizhny Tagil", "Nizhnyaya Salda", "Nizhnyaya Tura",
			 "Novolyalinskiy", "Novouralsk", "Pervouralsk", "Polevskoy", "Pyshminskiy", "Revda", "Rezhevskoy",
			  "Serov", "Serovsky", "Severouralsk", "Shalinsky", "Slobodo-Turyinskiy", "Sukholozhskiy", "Sysertskiy",
			  "Taborinskiy", "Talitskiy", "Tavdinskiy", "Tugulimskiy", "Turinskiy", "Verkhn`aya Pishma",
			  "Verkhne-saldinsky", "Verkhotursky", "Volchanskiy", "Ykb", "Zarechniy", "Svobodniy", "Uralskiy"

			};
	public static String [] avail = {
			"no data", "by bus/by car", "by bus/by car/by train", "by train/by car", "by car", "by feet"
			};
	
	public static String [] status = {
			"n/a", "architectural monument", "natural monument", "archeological monument", "historical monument"
	};
	
	
	public static String [] poi_main_cat = {
			"archeological", "park or preserve", "sport", "crafts", "cuisine",
			"museum, exibition or collection", "scientific site", "vis.art and archit",
			"deposits", "pets and animals", "natural attraction", "historical site"
			};
	
	public static String [] poi_add_cat = {
			"n/a", "famous person", "famous object or place", "historical event", "pagan and folk legends", 
	"cristian legends", "paranormal or unexplaned facts", "believers", "healing properties", 
	"scientifically important"
	};
	
	
	public static String [] poi_sub1 = {
			"n/a", "spring", "cave", "pictograms, image or text", "hot springs", "natural park", "burial", "zoo",
	"bridge", "megalits", "lake", "mountain", "scientific museum", "museum of vis. arts, literature or music", "waterfall",
	"education, library", "amusement park"
	};
	
	public static String [] poi_sub2 = {
			"n/a", "rock", "mine", "history and ethnography museum", "cemetery", "cult", "industrial object or museum",
	"artefacts", "observatory", "hippodrom", "settlement", "famous person`s museum", "building or construction",
	"monument", "park or designed area", "minerological mus or exposition", "military object or museum",
	"sanctuary", "peloid"
	};
	
	
	public static String [] poi_period = {
	"n/a", "not indicated", "before b.c.", "stone age", "neolith", "middle ages (before 17 cent)", 
	"built or established before 19 cent", "19 cent"
	};
	
	
	
	public static Integer [] rating = {
			1, 2, 3, 4, 5
	};

	public static Set <String> main_categories = new HashSet <String>();
	public static Set <String> subcat1 = new HashSet <String>();
	public static Set <String> subcat2 = new HashSet <String>();
	public static Set <String> distr = new HashSet <String>();
	public static Set <String> stat = new HashSet <String>();
	public static Set <String> add_cat = new HashSet <String>();
	public static Set <String> period = new HashSet <String>();
	
	@PostConstruct
	private void postConstruct() 
	{
		//In this method the data is being uploaded from the DB to related singleton lists or sets.
		log.info("ENTER postConstruct()");
	        
		log.info("EXIT postConstruct()");
	}
	
	
	public static Set<String> getMain_categories() {
		return main_categories;
	}
	
	public static Set<String> getSubcat1() {
		return subcat1;
	}
	
	public static Set<String> getSubcat2() {
		return subcat2;
	}
	
	public static Set<String> getDistr() {
		return distr;
	}
	
	public static Set<String> getStat() {
		return stat;
	}
	
	public static Set<String> getAdd_cat() {
		return add_cat;
	}
	
	public static Set<String> getPeriod() {
		return period;
	}

}
