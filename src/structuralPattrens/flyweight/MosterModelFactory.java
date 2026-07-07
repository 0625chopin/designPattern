package structuralPattrens.flyweight;

import java.util.HashMap;
import java.util.Map;

// [플라이웨이트 패턴 - FlyweightFactory(공유 객체 관리자) 역할]
// 플라이웨이트 객체를 캐시(풀)에 보관하며, 요청 시 이미 있으면 재사용하고 없으면 생성해 등록한다.
// 클라이언트가 직접 new 하지 않고 이 팩토리를 거치게 하여 '공유'를 보장하는 것이 핵심이다.
public class MosterModelFactory {
    // Flyweight Pool - MosterModel 객체들을 Map으로 등록하여 캐싱
    private static final Map<String, MosterModel> cache = new HashMap<>();

    public static MosterModel getInstance(String key) {

        // 이미 캐시에 있으면 새로 만들지 않고 그대로 재사용
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
