package com.sys.domain;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 万能类
 * @author peter
 * @version 1.1
 * @date 2019/6/21 11:20
 */
public class PageData  extends HashMap implements Map {
        private static final long serialVersionUID = 1L;

        Map map = null;
        HttpServletRequest request;

        public PageData(HttpServletRequest request){
            this.request = request;
            Map properties = request.getParameterMap();
            Map returnMap = new HashMap();
            Iterator entries = properties.entrySet().iterator();
            Entry entry;
            String name = "";
            String value = "";
            while (entries.hasNext()) {
                entry = (Entry) entries.next();
                name = (String) entry.getKey();
                Object valueObj = entry.getValue();
                if(null == valueObj){
                    value = "";
                }else if(valueObj instanceof String[]){
                    String[] values = (String[])valueObj;
                    for(int i=0;i<values.length;i++){
                        value = values[i] + ",";
                    }
                    value = value.substring(0, value.length()-1);
                }else{
                    value = valueObj.toString();
                }
                returnMap.put(name, value);
            }
            map = returnMap;
        }

        public PageData() {
            map = new HashMap();
        }

        @Override
        public Object get(Object key) {
            Object obj = null;
            if(map.get(key) instanceof Object[]) {
                Object[] arr = (Object[])map.get(key);
                obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
            } else {
                obj = map.get(key);
            }
            return obj;
        }

        public String getString(Object key) {
            if(null==key){
                return "";
            }
            Object v = get(key);
            if(null==v){
                return "";
            }
            return v.toString();
        }
        public Integer getInt(Object key) {
            if (null == key) {
                return null;
            }
            Object v = get(key);
            if (null == v) {
                return null;
            }
            return (int) Double.parseDouble(v.toString());
        }

        public Long getLong(Object key) {
            if (null == key) {
                return null;
            }
            Object v = get(key);
            if (null == v) {
                return null;
            }
            return Long.parseLong(v.toString());
        }

        public Double getDouble(Object key) {
            if (null == key) {
                return null;
            }
            Object v = get(key);
            if (null == v) {
                return null;
            }
            return Double.parseDouble(v.toString());
        }

        public Date getDate(Object key) {
            if (null == key) {
                return null;
            }
            Object v = get(key);
            if (null == v) {
                return null;
            }
            return DateUtil.parse(v.toString());
        }


        @Override
        public Object put(Object key, Object value) {
            return map.put(key, value);
        }

        @Override
        public Object remove(Object key) {
            return map.remove(key);
        }

        public void clear() {
            map.clear();
        }

        public boolean containsKey(Object key) {
            return map.containsKey(key);
        }

        public boolean containsValue(Object value) {
            return map.containsValue(value);
        }

        public Set entrySet() {
            return map.entrySet();
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public Set keySet() {
            return map.keySet();
        }

        public void putAll(Map t) {
            map.putAll(t);
        }

        public int size() {
            return map.size();
        }

        public Collection values() {
            return map.values();
        }

        public static String toListString(List<PageData> list) {
            JSONArray ja = new JSONArray();
            for (PageData new_pd : list) {
                ja.add(JSONUtil.parse(new_pd));
            }
            return ja.toString();
        }
}
