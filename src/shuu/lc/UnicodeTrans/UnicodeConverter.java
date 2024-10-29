package UnicodeTrans;

public class UnicodeConverter {
    public static void main(String[] args) {
        // 示例Unicode 16进制字符串
        String unicodeString = "\\u4F60\\u597D"; // 代表中文"你好"

        // 调用转换函数
        String result = decodeUnicode(unicodeString);

        // 输出结果
        System.out.println(result); // 输出：你好
    }

    public static String decodeUnicode(String unicodeString) {
        StringBuilder sb = new StringBuilder();
        String[] parts = unicodeString.split("\\\\u");

        // Loop through parts, skipping the first empty part if it exists
        for (int i = 1; i < parts.length; i++) {
            // 关键是在这里
            // Parse the integer value from the hex string
            int codePoint = Integer.parseInt(parts[i], 16);
            // Append the corresponding character to the StringBuilder
            sb.append((char) codePoint);
        }
        return sb.toString();
    }
}
