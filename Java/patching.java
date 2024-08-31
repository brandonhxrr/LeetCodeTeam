class Solution {
  public int minPatches(int[] nums, int n) {
    int result = 0;
    long maxCovered = 0; // Máximo valor que se puede cubrir con el arreglo actual

    // Convertir el array en una lista para facilitar la manipulación
    while (maxCovered < n) {
      boolean canCover = false;
      long sum = 0;

      // Verificar si podemos cubrir el siguiente número usando los números actuales
      for (int num : nums) {
        if (num > maxCovered + 1) {
          break; // Si el número es mayor que el próximo número que necesitamos cubrir, salimos del bucle
        }
        sum += num;
        if (sum >= maxCovered + 1) {
          canCover = true;
          break;
        }
      }

      // Si no podemos cubrir el próximo número, insertar un parche
      if (!canCover) {
        long patch = maxCovered + 1;
        // Insertar el parche en el array
        nums = insertAtPosition(nums, (int) patch, findInsertPosition(nums, (int) patch));
        System.out.println("Inserted patch: " + patch + " -> " + Arrays.toString(nums));
        maxCovered += patch; // Actualizar el máximo valor cubierto
        result++;
      } else {
        // Si podemos cubrir el próximo número, actualizar el máximo valor cubierto
        maxCovered += nums[0];
      }
    }

    return result;
  }

  // Método para encontrar la posición correcta de inserción
  private int findInsertPosition(int[] nums, int element) {
    int pos = 0;
    while (pos < nums.length && nums[pos] < element) {
      pos++;
    }
    return pos;
  }

  private int[] insertAtPosition(int[] nums, int element, int position) {
    int[] newNums = new int[nums.length + 1];
    for (int i = 0; i < position; i++) {
      newNums[i] = nums[i];
    }
    newNums[position] = element;
    for (int i = position; i < nums.length; i++) {
      newNums[i + 1] = nums[i];
    }
    return newNums;
  }
}