import java.util.*;


//Problem 1: Username Availability Checker//

class UsernameChecker {

    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void register(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=3;i++){
            list.add(username + i);
        }
        list.add(username.replace("_","."));
        return list;
    }

    public String getMostAttempted() {
        String res="";
        int max=0;

        for(String key: attempts.keySet()){
            if(attempts.get(key) > max){
                max = attempts.get(key);
                res = key;
            }
        }
        return res;
    }
}


//Problem 2: Flash Sale Inventory Manager//

class InventoryManager {

    HashMap<String, Integer> stock = new HashMap<>();
    LinkedHashMap<Integer,String> waitingList = new LinkedHashMap<>();

    public void addProduct(String id, int count){
        stock.put(id,count);
    }

    public synchronized String purchaseItem(String productId, int userId){

        int s = stock.getOrDefault(productId,0);

        if(s>0){
            stock.put(productId,s-1);
            return "Success. Remaining: "+(s-1);
        }else{
            waitingList.put(userId,productId);
            return "Added to waiting list";
        }
    }

    public int checkStock(String productId){
        return stock.getOrDefault(productId,0);
    }
}


//Problem 3: DNS Cache with TTL//

class DNSEntry {

    String ip;
    long expiry;

    DNSEntry(String ip,long ttl){
        this.ip = ip;
        this.expiry = System.currentTimeMillis()+ttl;
    }
}

class DNSCache {

    HashMap<String,DNSEntry> cache = new HashMap<>();
    int hits=0,miss=0;

    public String resolve(String domain){

        DNSEntry entry = cache.get(domain);

        if(entry!=null && entry.expiry > System.currentTimeMillis()){
            hits++;
            return entry.ip+" (CACHE HIT)";
        }

        miss++;
        String ip = "192.168."+new Random().nextInt(100)+"."+new Random().nextInt(100);

        cache.put(domain,new DNSEntry(ip,5000));
        return ip+" (CACHE MISS)";
    }

    public void stats(){
        System.out.println("Hits:"+hits+" Miss:"+miss);
    }
}


//Problem 4: Plagiarism Detector//

class PlagiarismDetector {

    HashMap<String,Set<String>> ngrams = new HashMap<>();
    int N = 5;

    public List<String> generate(String text){

        String[] words = text.split(" ");
        List<String> grams = new ArrayList<>();

        for(int i=0;i<=words.length-N;i++){

            String g="";
            for(int j=0;j<N;j++)
                g += words[i+j]+" ";

            grams.add(g.trim());
        }

        return grams;
    }

    public void addDocument(String id,String text){

        for(String g:generate(text)){

            ngrams.putIfAbsent(g,new HashSet<>());
            ngrams.get(g).add(id);
        }
    }

    public int similarity(String text){

        int match=0;

        for(String g:generate(text))
            if(ngrams.containsKey(g))
                match++;

        return match;
    }
}


//Problem 5: Real Time Analytics Dashboard//

class Analytics {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String,Set<String>> uniqueUsers = new HashMap<>();
    HashMap<String,Integer> sources = new HashMap<>();

    public void process(String url,String user,String source){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueUsers.putIfAbsent(url,new HashSet<>());
        uniqueUsers.get(url).add(user);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    public void dashboard(){

        System.out.println("Pages:"+pageViews);
        System.out.println("Sources:"+sources);
    }
}


//Problem 6: Rate Limiter//

class TokenBucket {

    int tokens;
    int max;
    long last;

    TokenBucket(int max){
        this.tokens=max;
        this.max=max;
        last=System.currentTimeMillis();
    }
}

class RateLimiter {

    HashMap<String,TokenBucket> clients = new HashMap<>();

    public boolean check(String id){

        clients.putIfAbsent(id,new TokenBucket(1000));

        TokenBucket b = clients.get(id);

        long now = System.currentTimeMillis();

        if(now - b.last > 3600000){
            b.tokens=b.max;
            b.last=now;
        }

        if(b.tokens>0){
            b.tokens--;
            return true;
        }

        return false;
    }
}



//Problem 7: Autocomplete System//

class AutoComplete {

    HashMap<String,Integer> freq = new HashMap<>();

    public void addQuery(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    public List<String> search(String prefix){

        List<String> list = new ArrayList<>();

        for(String q:freq.keySet())
            if(q.startsWith(prefix))
                list.add(q);

        list.sort((a,b)->freq.get(b)-freq.get(a));

        return list.size()>5 ? list.subList(0,5) : list;
    }
}


//Problem 8: Parking Lot (Open Addressing)//

class ParkingLot {

    String[] spots = new String[500];

    int hash(String plate){
        return Math.abs(plate.hashCode())%spots.length;
    }

    public int park(String plate){

        int i = hash(plate);

        while(spots[i]!=null)
            i = (i+1)%spots.length;

        spots[i]=plate;

        return i;
    }

    public void exit(String plate){

        for(int i=0;i<spots.length;i++)
            if(plate.equals(spots[i]))
                spots[i]=null;
    }
}


//Problem 9: Two Sum Transactions//

class TwoSum {

    public void findTwoSum(int[] arr,int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n:arr){

            int comp = target-n;

            if(map.containsKey(comp))
                System.out.println("Pair:"+n+" "+comp);

            map.put(n,1);
        }
    }
}


//Problem 10: Multi Level Cache//

class MultiCache {

    LinkedHashMap<String,String> L1 =
            new LinkedHashMap<>(100,0.75f,true);

    HashMap<String,String> L2 = new HashMap<>();

    public String getVideo(String id){

        if(L1.containsKey(id)){
            return "L1 HIT";
        }

        if(L2.containsKey(id)){
            L1.put(id,L2.get(id));
            return "L2 HIT";
        }

        L2.put(id,"VideoData");
        return "DB HIT";
    }
}



//MAIN CLASS//

public class SystemsDemo {

    public static void main(String[] args) {

        UsernameChecker u = new UsernameChecker();
        u.register("john_doe",1);

        System.out.println(u.checkAvailability("john_doe"));
        System.out.println(u.suggestAlternatives("john_doe"));

        InventoryManager inv = new InventoryManager();
        inv.addProduct("IPHONE",2);

        System.out.println(inv.purchaseItem("IPHONE",101));
        System.out.println(inv.purchaseItem("IPHONE",102));
        System.out.println(inv.purchaseItem("IPHONE",103));

        DNSCache dns = new DNSCache();
        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));

        Analytics a = new Analytics();
        a.process("/news","u1","google");
        a.process("/news","u2","facebook");
        a.dashboard();

        RateLimiter r = new RateLimiter();
        System.out.println(r.check("client1"));

        AutoComplete ac = new AutoComplete();
        ac.addQuery("java tutorial");
        ac.addQuery("javascript tutorial");
        System.out.println(ac.search("jav"));

        ParkingLot p = new ParkingLot();
        System.out.println("Spot:"+p.park("ABC123"));

        TwoSum t = new TwoSum();
        t.findTwoSum(new int[]{500,300,200},500);

        MultiCache mc = new MultiCache();
        System.out.println(mc.getVideo("video1"));
        System.out.println(mc.getVideo("video1"));
    }
}