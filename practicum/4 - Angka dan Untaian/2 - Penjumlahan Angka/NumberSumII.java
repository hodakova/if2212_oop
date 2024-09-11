public class NumberSumII {
    public Number sumNumberII(Number[] numArr) {
        Number resNumber = 0, prevResNumber = 0;
        for(Number number : numArr) {
            if(number instanceof Byte) {
                prevResNumber = resNumber.byteValue();
                resNumber = resNumber.byteValue() + number.byteValue();
                if(prevResNumber.byteValue() > 0 && number.byteValue() > 0 && resNumber.byteValue() < 0) {
                    resNumber = Byte.MAX_VALUE;
                }
                else if(prevResNumber.byteValue() < 0 && number.byteValue() < 0 && resNumber.byteValue() > 0) {
                    resNumber = Byte.MIN_VALUE;
                }
            }
            else if(number instanceof Integer) {
                prevResNumber = resNumber.intValue();
                resNumber = resNumber.intValue() + number.intValue();
                if(prevResNumber.intValue() > 0 && number.intValue() > 0 && resNumber.intValue() < 0) {
                    resNumber = Integer.MAX_VALUE;
                }
                else if(prevResNumber.intValue() < 0 && number.intValue() < 0 && resNumber.intValue() > 0) {
                    resNumber = Integer.MIN_VALUE;
                }
            }
            else if(number instanceof Double) {
                prevResNumber = resNumber.doubleValue();
                resNumber = resNumber.doubleValue() + number.doubleValue();
                if(prevResNumber.doubleValue() > 0 && number.doubleValue() > 0 && resNumber.doubleValue() < 0) {
                    resNumber = Double.MAX_VALUE;
                }
                else if(prevResNumber.doubleValue() < 0 && number.doubleValue() < 0 && resNumber.doubleValue() > 0) {
                    resNumber = Double.MIN_VALUE;
                }
            }
            else if(number instanceof Float) {
                prevResNumber = resNumber.floatValue();
                resNumber = resNumber.floatValue() + number.floatValue();
                if(prevResNumber.floatValue() > 0 && number.floatValue() > 0 && resNumber.floatValue() < 0) {
                    resNumber = Float.MAX_VALUE;
                }
                else if(prevResNumber.floatValue() < 0 && number.floatValue() < 0 && resNumber.floatValue() > 0) {
                    resNumber = Float.MIN_VALUE;
                }
            }
            else if(number instanceof Short) {
                prevResNumber = resNumber.shortValue(); 
                resNumber = resNumber.shortValue() + number.shortValue();
                if(prevResNumber.shortValue() > 0 && number.shortValue() > 0 && resNumber.shortValue() < 0) {
                    resNumber = Short.MAX_VALUE;
                }
                else if(prevResNumber.shortValue() < 0 && number.shortValue() < 0 && resNumber.shortValue() > 0) {
                    resNumber = Short.MIN_VALUE;
                }
            }
            else if(number instanceof Long) {
                prevResNumber = resNumber.longValue();
                resNumber = resNumber.longValue() + number.longValue();
                if(prevResNumber.longValue() > 0 && number.longValue() > 0 && resNumber.longValue() < 0) {
                    resNumber = Long.MAX_VALUE;
                }
                else if(prevResNumber.longValue() < 0 && number.longValue() < 0 && resNumber.longValue() > 0) {
                    resNumber = Long.MIN_VALUE;
                }
            }
        }
        return resNumber;
    }
}