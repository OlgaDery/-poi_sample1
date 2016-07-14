/**
 * 
 */
package utils_for_servlet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Olga
 *
 */
public class Constants_for_app {

	/**
	 * 
	 */
	public Constants_for_app() {
		// TODO Auto-generated constructor stub
	}
	public static final String []  DISTRICT = {
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
	public static final Integer [] DISTRICT_INDEX = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
			26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
			51, 52, 53, 54, 55, 56, 57, 58, 59
			};
	
	public static final String [] AVAIL = {
			"no data", "by bus/by car", "by bus/by car/by train", "by train/by car", "by car", "by feet"
			};
	
	public static final Integer [] AVAIL_INDEX = {
			0, 1, 2, 3, 4, 5
			};
	
	public static final String [] STATUS = {
			"architectural monument", "natural monument", "archeological monument", "historical monument"
			};
	public static final Integer [] STATUS_INDEX = {
			1, 2, 3, 4
			};
	
	public static final String [] SPEC_PLACES = {
			"famous person", "famous object or place", "historical event", "pagan and folk legends", 
			"cristian legends", "paranormal or unexplaned facts", "believers", "healing properties", 
			"scientifically important"
			};
	public static final Integer [] SPEC_PLACES_INDEX = {
			1, 2, 3, 4, 5, 6, 7, 8, 9
			};
	
	public static final String [] NAT_POI_SUB1 = {
			"spring", "cave", "hot springs", "natural park", "lake", "mountain", "waterfall"
			};
	public static final String [] NAT_POI_SUB2 = {
			"rock", "mine", "park or designed area", 
			"peloid"
			};
	
	public static final String [] ARCHIT_POI_SUB1 = {
			"pictograms, image or text", "burial", "bridge", "megalits"
			};
	

	public static final String [] ARCHIT_POI_SUB2 = {
			"cemetery", "cult", "artefacts", "settlement", "building or construction",
			"monument"
			};
	public static final String [] MUS_POI_SUB1 = {
			"scientific museum", "museum of arts", "education, library"
			};
	
	public static final String [] MUS_POI_SUB2 = {
			"history and ethnography museum", "industrial object or museum",
			"famous person`s museum", "minerological mus or exposition", "military object or museum", "observatory"
			};
	
	public static final String [] OTHER_POI_SUB1 = {
			"zoo", "amusement park"
			};
	
	public static final String [] OTHER_POI_SUB2 = {
			"hippodrom", "sanctuary"
			};
	public static final String [] HISTOR_PERIOD = {
			"before b.c.", "middle ages (before 17 cent)", 
			"built or established before 19 cent", "19 cent"
			};
	public static final Integer [] HISTOR_PERIOD_INDEX = {
			2, 5, 6, 7
			};
	
	public static final Integer [] RATING_INDEX = {
			0, 1, 2, 3, 4
			};
	
	public final static String [] RATING = {
			"1", "2", "3", "4", "5"
	};
	
	public final static String [] POI_SUB1 = {
			"spring", "cave", "pictograms, image or text", "hot springs", "natural park", "burial", "zoo",
			"bridge", "megalits", "lake", "mountain", "scientific museum", "museum of arts", "waterfall",
			"education, library", "amusement park"
			};
	public static final Integer [] SUB1_INDEX = {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17
			};
	public final static String [] POI_SUB2 = {
			"rock", "mine", "history and ethnography museum", "cemetery", "cult", "industrial object or museum",
			"artefacts", "observatory", "hippodrom", "settlement", "famous person`s museum", "building or construction",
			"monument", "park or designed area", "minerological mus or exposition", "military object or museum",
			"sanctuary", "peloid"
			};
	
	public static final Integer [] SUB2_INDEX = {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18
			};
	
	public static List<Map<Integer, String>> poi_Filter(String []  data_list) {
		
		List<Map<Integer, String>> st_list = new LinkedList<Map<Integer, String>>();
		for (String d : data_list) {
			Map<Integer, String> st = new HashMap <Integer, String>();
			Integer ind = Arrays.asList(data_list).indexOf(d);
			st.put(ind, d);
			st_list.add(st);
		}
//		st_list.add(st);
		return st_list;
	}

}
