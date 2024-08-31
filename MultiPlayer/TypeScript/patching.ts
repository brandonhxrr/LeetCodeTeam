function minPatches(nums: number[], n: number): number {
    let result = 0; // To keep track of the number of patches needed
    let maxCovered = 0; // The maximum value that can be covered with the current array
    let index = 0; // Index to iterate through the nums array

    // Continue until we have covered all values up to n
    while (maxCovered < n) {
      // If the current index is within bounds and the current number is <= maxCovered
      // + 1
      if (index < nums.length && nums[index] <= maxCovered + 1) {
        // Extend the range of covered values by including nums[index]
        maxCovered += nums[index];
        index++; // Move to the next number in the array
      } else {
        // If we can't cover maxCovered + 1, we need to add a patch
        const patch = maxCovered + 1; // The value of the patch we need to add
        maxCovered += patch; // Extend the range of covered values by including the patch
        result++; // Increment the patch count
      }
    }

    // Return the total number of patches needed
    return result;
};