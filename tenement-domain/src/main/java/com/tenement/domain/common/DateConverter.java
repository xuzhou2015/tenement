package com.tenement.domain.common;

import org.dozer.ConfigurableCustomConverter;
import org.springframework.util.StringUtils;


import java.util.Date;

public class DateConverter implements ConfigurableCustomConverter {

    /**
     * 参数(日期格式,默认:yyyy-MM-dd HH:mm:ss)
     */
    private String parameter;

    @SuppressWarnings({"rawtypes"})
    @Override
    public Object convert(Object existingDestinationFieldValue,
                          Object sourceFieldValue, Class destinationClass, Class sourceClass) {
        Object obj = null;
        if (null != sourceFieldValue) {
            if (sourceFieldValue instanceof String) {
                // 字符转日期类型
                if (!StringUtils.isEmpty((String) sourceFieldValue) && !sourceFieldValue.equals("0")) {
                    obj = DateUtils.parseToDate((String) sourceFieldValue, getDateFormat());
                }
            } else if (sourceFieldValue instanceof Date) {
                // 日期类型转字符
                obj = DateUtils.format((Date) sourceFieldValue, getDateFormat());
            }
        }
        return obj;
    }

    private String getDateFormat() {
        return StringUtils.isEmpty(parameter) ? DateUtils.FMT_SECOND : parameter;
    }

    @Override
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}