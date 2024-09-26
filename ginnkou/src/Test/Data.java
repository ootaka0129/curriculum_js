package Test;

import java.util.HashMap;
import java.util.Map;

public class Data {
	public static Map<Integer,PassBook> start() {
		Map<Integer,PassBook> m = new HashMap<Integer,PassBook>();
		//名前、支店番号、口座番号、残金の順番でデータが入る
		//PassBookクラスのPassBookコンストラクタで初期化
		m.put(1,new PassBook("田中",150,132431,200000));
		m.put(2,new PassBook("山田",150,132432,200000));
		m.put(3,new PassBook("藤田",150,132433,200000));
		m.put(4,new PassBook("田本",149,132434,200000));
		m.put(5,new PassBook("高田",149,132435,200000));
		return m;
	}
}

