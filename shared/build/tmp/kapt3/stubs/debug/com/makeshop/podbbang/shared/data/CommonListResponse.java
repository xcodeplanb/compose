package com.makeshop.podbbang.shared.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J=\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/makeshop/podbbang/shared/data/CommonListResponse;", "T", "", "result", "", "status", "", "data", "", "error", "Lcom/makeshop/podbbang/shared/data/ErrorResponse;", "(ZILjava/util/List;Lcom/makeshop/podbbang/shared/data/ErrorResponse;)V", "getData", "()Ljava/util/List;", "getError", "()Lcom/makeshop/podbbang/shared/data/ErrorResponse;", "setError", "(Lcom/makeshop/podbbang/shared/data/ErrorResponse;)V", "getResult", "()Z", "getStatus", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "shared_debug"})
public final class CommonListResponse<T extends java.lang.Object> {
    private final boolean result = false;
    private final int status = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<T> data = null;
    @org.jetbrains.annotations.NotNull()
    private com.makeshop.podbbang.shared.data.ErrorResponse error;
    
    public CommonListResponse(boolean result, int status, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> data, @org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.ErrorResponse error) {
        super();
    }
    
    public final boolean getResult() {
        return false;
    }
    
    public final int getStatus() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<T> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.ErrorResponse getError() {
        return null;
    }
    
    public final void setError(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.ErrorResponse p0) {
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<T> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.ErrorResponse component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.CommonListResponse<T> copy(boolean result, int status, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> data, @org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.ErrorResponse error) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}