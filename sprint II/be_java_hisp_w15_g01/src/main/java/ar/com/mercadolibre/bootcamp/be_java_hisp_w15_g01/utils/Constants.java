package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

public class Constants {

    public static final String ID_NOT_NULL = "El id no puede ser nulo";
    public static final String ID_NOT_ZERO = "El id no puede ser cero";
    public static final int ID_VALUE = 1;

    public static final String NOMBRE_NOT_NULL = "El nombre no puede ser nulo";
    public static final String NOMBRE_MAX_VALUE = "El nombre no puede ser mayor a 40 caracteres";
    public static final String NOMBRE_REGEX = "El nombre debe contener solo letras y numeros";
    public static final int NAME_VALUE = 40;

    public static final String TIPO_NOT_NULL = "El tipo no puede ser nulo";
    public static final String TIPO_MAX_VALUE = "El tipo no puede ser mayor a 15 caracteres";
    public static final String TIPO_REGEX = "El tipo debe contener solo letras y numeros";
    public static final int TIPO_VALUE = 15;

    public static final String BRAND_NOT_NULL = "La marca no puede ser nula";
    public static final String BRAND_MAX_VALUE = "La marcano puede ser mayor a 25 caracteres";
    public static final String BRAND_REGEX = "La marca debe contener solo letras y numeros";
    public static final int BRAND_VALUE = 25;

    public static final String COLOR_NOT_NULL = "El color no puede ser nulo";
    public static final String COLOR_MAX_VALUE = "El color no puede ser mayor a 15 caracteres";
    public static final String COLOR_REGEX = "El color debe contener solo letras y numeros";
    public static final int COLOR_VALUE = 15;

    public static final String NOTES_MAX_VALUE = "El largo de la nota no puede ser mayor a 80 caracteres";
    public static final String NOTES_REGEX = "La nota debe contener solo letras y numeros";
    public static final int NOTES_VALUE = 80;

    public static final String SIMBOLS_REGEX = "[A-Za-z0-9\\\\s]|^$";

    public static final String CATEGORY_NOT_NULL = "La categoria no puede ser nula";

    public static final String PRICE_NOT_NULL = "El precio no puede ser nulo";
    public static final String PRICE_MAX_VALUE = "El precio no puede ser mayor a 10 millones";
    public static final int PRICE_VALUE = 10000000;

    public static final String DATE_NOT_NULL = "La fecha no puede ser nula";
    public static final String DATE_FORMAT = "El formato de la fecha debe ser dd-MM-yyyy";
    public static final String DATE_REGEX = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$";

    public static final String ORDER_REGEX = "name_asc|name_desc|date_asc|date_desc";
    public static final String ORDER_MESSAGE = "No es un parametro de ordenamiento valido";

    public static final String DETAIL_NOT_NULL = "El detalle del producto no puede ser nulo";
}
