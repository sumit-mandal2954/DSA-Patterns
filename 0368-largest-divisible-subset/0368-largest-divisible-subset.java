class Solution {
	public ArrayList<Integer> largestDivisibleSubset(int arr[]) {
	    Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		int dp[] = new int[arr.length];
		int hash [] = new int[arr.length];
		for (int i = 0; i<arr.length; i++) {
			hash[i] = i;
		}
		Arrays.fill(dp, 1);
		int lastIdx = 0;
		int max = 1;
		for (int i = 0; i<arr.length; i++) {
			for (int pre = 0; pre<i; pre++) {
				if (arr[i]%arr[pre]==0 && 1 + dp[pre]>dp[i]) {
					dp[i] = 1 + dp[pre];
					hash[i] = pre;
				}
			}
			if (dp[i]>max) {
				max = dp[i];
				lastIdx = i;
			}
		}

		while (hash[lastIdx]!=lastIdx) {
			list.add(arr[lastIdx]);
			lastIdx = hash[lastIdx];
		}
		list.add(arr[lastIdx]);
		Collections.reverse(list);
		return list;
	}
}
