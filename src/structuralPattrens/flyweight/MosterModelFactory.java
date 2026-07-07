package structuralPattrens.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight facory
public class MosterModelFactory {
    // Flyweight Pool - TreeModel 객체들을 Map으로 등록하여 캐싱
    private static final Map<String, MosterModel> cache = new HashMap<>();

    public static MosterModel getInstance(String key) {

        if(cache.containsKey(key)) {
            return cache.get(key);
        } else {
            MosterModel mosterModel = new MosterModel(
                    key,
                    new Object(),
                    new Object()
            );

            System.out.println("--- 몬스터 모델 객체 신규 생성 완료 ----");

            // 캐시이 적제
            cache.put(key, mosterModel);
            return mosterModel;
        }
    }

}
