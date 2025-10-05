import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reservedMap = new HashMap<>();
        for (int[] seat : reservedSeats) {
            reservedMap.computeIfAbsent(seat[0], k-> new HashSet<>()).add(seat[1]);
        }
        int count = 0;
        for (int row : reservedMap.keySet()) {
            Set<Integer> reserved = reservedMap.get(row);
            boolean left = !(reserved.contains(2) || reserved.contains(3) 
            || reserved.contains(4) || reserved.contains(5));
            boolean middle = !(reserved.contains(4) || reserved.contains(5) 
            || reserved.contains(6) || reserved.contains(7));
            boolean right = !(reserved.contains(6) || reserved.contains(7) 
            || reserved.contains(8) || reserved.contains(9));
            if(left && right) {
                count+=2;
            } else if(left || right || middle) {
                count+=1;
            }
        }
        count += 2*(n-reservedMap.size());
        return count;
    }
}
