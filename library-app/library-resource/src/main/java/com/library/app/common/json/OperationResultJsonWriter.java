package com.library.app.common.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.library.app.common.model.OperationResult;

/**
 * @author fatu
 */
public final class OperationResultJsonWriter {
    private OperationResultJsonWriter() {
    }

    public static String toJson(OperationResult operationResult) {
        return JsonWriter.writeToString(getJsonObject(operationResult));
    }

    private static Object getJsonObject(OperationResult operationResult) {
        if (operationResult.isSuccess()) {
            return getJsonSuccess(operationResult);
        }
        return getJsonError(operationResult);
    }

    private static Object getJsonSuccess(OperationResult operationResult) {
        return operationResult.getEntity();
    }

    private static JsonObject getJsonError(OperationResult operationResult) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("errorIdentification", operationResult.getErrorIdentification());
        jsonObject.addProperty("errorDescription", operationResult.getErrorDescription());

        return jsonObject;
    }
}
