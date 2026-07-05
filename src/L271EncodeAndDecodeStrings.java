///Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
/// Machine 1 (sender) has the function:
/// String encode(List<String> strs) {
///     // ... your code
///     return encoded_string;
/// }
/// Machine 2 (receiver) has the function:
/// List<String> decode(String encoded_string) {
///     // ... your code
///     return decoded_strs;
/// }
/// So Machine 1 does:
/// String encoded_string = encode(strs);
/// and Machine 2 does:
/// List<String> decoded_strs = decode(encoded_string);
/// decoded_strs in Machine 2 should be the same as the input strs in Machine 1.
/// Implement the encode and decode methods.
///
/// Example 1:
/// Input: strs = ["Hello","World"]
/// Output: ["Hello","World"]
/// Explanation:
/// Solution solution = new Solution();
/// String encoded_string = solution.encode(strs);
///
/// // Machine 1 ---encoded_string---> Machine 2
///
/// List<String> decoded_strs = solution.decode(encoded_string);
///
///
/// Example 2:
/// Input: strs = [""]
/// Output: [""]
///
/// Constraints:
///     0 <= strs.length < 100
///     0 <= strs[i].length < 200
///     strs[i] contains any possible characters out of 256 valid ASCII characters.

import java.util.*;
public class L271EncodeAndDecodeStrings {
    public String encode(String str) {
        //easiest ways to encode is by adding delimiters between the chars to the string
        String delimiter = "/-/";
        return String.join(delimiter, str);
    }

    public String decode(String str) {
        String delimiter = "/-/";
        return str.replaceAll(delimiter, "");
    }

    public void main(String[] args) {
        String str = "abcdefg";
        String encoded = encode(str);

        System.out.println(encoded);

    }


}
