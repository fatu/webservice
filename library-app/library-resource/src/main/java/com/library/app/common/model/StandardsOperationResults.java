package com.library.app.common.model;

import com.library.app.category.resource.common.exception.FieldNotValidException;

/**
 * @author fatu
 */
public final class StandardsOperationResults {
    public StandardsOperationResults() {
    }

    public static OperationResult getOperationResultExistent(final ResourceMessage resourceMessage, String fieldsNames) {
        return OperationResult.error(resourceMessage.getKeyOfResourceExistent(), resourceMessage
            .getMessageOfResourceExistent(fieldsNames));
    }

    public static OperationResult getOperationResultInvalidField(final ResourceMessage resourceMessage,
                                                                 FieldNotValidException ex) {
        return OperationResult.error(resourceMessage.getKeyOfInvalidField(ex.getFieldName()), ex.getMessage());
    }

    public static OperationResult getOperationResultNotFound(final ResourceMessage resourceMessage) {
        return OperationResult.error(resourceMessage.getKeyOfResourceNotFound(), resourceMessage
            .getMessageOfResourceNotFound());
    }
}
