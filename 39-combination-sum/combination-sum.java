class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, target, 0, current, result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Valid combination found
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Since candidates are sorted,
            // no later candidate can fit either.
            if (candidates[i] > target) {
                break;
            }

            // Choose the current candidate
            current.add(candidates[i]);

            // Pass i again because the same number
            // can be selected unlimited times.
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Undo the choice
            current.remove(current.size() - 1);
        }
    }
}