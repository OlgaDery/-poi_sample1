/**
 * 
 */
package parameters_for_filtering;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Olga Deryabina.
 * Here we have the arrays of parameters for filtering points of interests. They are being stored as ServletContext attributes
 * in the contextInitialized method of App_config_listener.
 *
 */
public class Constants_for_pois {

	/**
	 * 
	 */
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

	
	public static List<Map<Integer, String>> poi_Filter(String []  data_list, Integer [] indexes) {
		
		List<Map<Integer, String>> st_list = new LinkedList<Map<Integer, String>>();
		for (String d : data_list) {
			Map<Integer, String> st = new HashMap <Integer, String>();
			Integer ind = Arrays.asList(data_list).indexOf(d);
			st.put(indexes[ind], d);
			st_list.add(st);
		}
//		st_list.add(st);
		return st_list;
	}

}
