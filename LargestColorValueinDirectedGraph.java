class Solution {
    
	static class Node {
	    // Stores the max frequency of color for this node.
		// There may be multiple paths leading to this node, for each color,
		// only the one with max count is needed here.
		public int[] colors = new int[26];
		public int colorIndex;

		Node (char c) {
			colorIndex = c - 'a';
		}

		public void start() {
			colors[colorIndex]++;
		}

		// This is the key. When visiting a node, no matter which path leads to this node,
		// we only need to store the max color frequency.
		// Of course, you need to add 1 for this node's color.
		public void visit(int[] pre) {
			for (int i = 0; i < pre.length; ++i) {
				colors[i] = Math.max(pre[i] + (i == colorIndex ? 1 : 0), colors[i]);
			}
		}

		public int maxColor() {
			int max = 0;
			for (int c : colors) {
				max = Math.max(max, c);
			}
			return max;
		}
	}

	public int largestPathValue(String colors, int[][] edges) {
		char[] colorMap = colors.toCharArray();
		int nodeSize = colorMap.length;

		int[] indegrees = new int[nodeSize];
		List<Integer>[] outdegrees = new ArrayList[nodeSize];
		for (int i = 0; i < nodeSize; ++i) {
			outdegrees[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			indegrees[to]++;
			outdegrees[from].add(to);
		}

		Node[] nodes = new Node[nodeSize];
		for (int i = 0; i < nodeSize; ++i) {
			nodes[i] = new Node(colorMap[i]);
		}
		int count = 0;
		Queue<Integer> visiting = new LinkedList<>();
		for (int i = 0; i < nodeSize; ++i) {
			if (indegrees[i] == 0) {
				visiting.offer(i);
				++count;
				nodes[i].start();
			}
		}

		int ans = 0;
		while (!visiting.isEmpty()) {
			int label = visiting.poll();
			if (outdegrees[label].isEmpty()) {
				ans = Math.max(ans, nodes[label].maxColor());
			}
			for (int next : outdegrees[label]) {
				nodes[next].visit(nodes[label].colors);
				if (--indegrees[next] == 0) {
					visiting.offer(next);
					++count;
				}
			}
		}

		return count == nodeSize ? ans : -1;
	}
}
