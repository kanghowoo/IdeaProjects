package binarySearch.beakjoon1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] nArray = new int[k];

        long max = 0;

        for(int i=0; i<k; i++) {
            nArray[i] = Integer.parseInt(br.readLine());
            if(max < nArray[i]) {
                max = nArray[i];
            }
        }

        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {

            // 범위 내에서 중간 길이를 구한다.
            mid = (max + min) / 2;


            long count = 0;

            // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.

            for (int i = 0; i < nArray.length; i++) {
                count += (nArray[i] / mid);
            }

            /*
             *  [upper bound 형식]
             *
             *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */
            if(count < n) {
                max = mid;
            }
            else {
                min = mid + 1;
            }


        }

        // UpperBound로 얻어진 값(min)에 -1이 최대 길이가 된다.
        System.out.println(min - 1);

    }
}
