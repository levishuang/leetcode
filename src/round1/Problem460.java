package round1;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/9 15:48
 */

public class Problem460 {
    class LFUCache {
        //key到val的映射
        HashMap<Integer, Integer> keyToVal;
        //key到freq的映射
        HashMap<Integer, Integer> keyToFreq;
        //freq到key的映射
        HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
        //保存最小值
        int minFreq;
        //设置容量大小
        int cap;


        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKey = new HashMap<>();
            this.minFreq = 0;
            this.cap = capacity;
        }

        //获取key对应的值
        public int get(int key) {
            if(!keyToVal.containsKey(key)){
                return -1;
            }
            //增加key对应的频率,既要更新keyToFreq, 又要更新freqToKey
            increaseFreq(key);
            return keyToVal.get(key);
        }

        private void increaseFreq(int key) {
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq+1);
            freqToKey.get(freq).remove(key);
            freqToKey.putIfAbsent(freq+1, new LinkedHashSet<>());
            freqToKey.get(freq+1).add(key);
            if(freqToKey.get(freq).isEmpty()){
                freqToKey.remove(freq);
                if(freq == minFreq){
                    minFreq++;
                }
            }
        }

        public void put(int key, int value) {
            if(cap <= 0) return;
            if(keyToVal.containsKey(key)){
                //更新val值并增加频率
                keyToVal.put(key, value);
                increaseFreq(key);
                return;
            }
            if (cap <= keyToVal.size()){
                removeMinFreq();
            }
            //新增一个键值对
            addNew(key, value);
        }

        private void addNew(int key, int value) {
            keyToVal.put(key,value);
            keyToFreq.put(key, 1);
            freqToKey.putIfAbsent(1, new LinkedHashSet<>());
            //更新频率为1的hashset
            freqToKey.get(1).add(key);
            this.minFreq = 1;
        }

        private void removeMinFreq() {
            // freq 最小的 key 列表
            LinkedHashSet<Integer> keyList = freqToKey.get(this.minFreq);
            // 其中最先被插入的那个 key 就是该被淘汰的 key
            int deletedKey = keyList.iterator().next();
            /* 更新 FK 表 */
            keyList.remove(deletedKey);
            if (keyList.isEmpty()) {
                freqToKey.remove(this.minFreq);
                // 问：这里需要更新 minFreq 的值吗？
            }
            /* 更新 KV 表 */
            keyToVal.remove(deletedKey);
            /* 更新 KF 表 */
            keyToFreq.remove(deletedKey);
        }
    }
}
