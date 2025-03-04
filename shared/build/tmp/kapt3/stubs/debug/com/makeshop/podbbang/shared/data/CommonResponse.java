package com.makeshop.podbbang.shared.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0004H\u00c6\u0003J\u000e\u0010\u0013\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/makeshop/podbbang/shared/data/CommonResponse;", "T", "", "status", "", "data", "error", "Lcom/makeshop/podbbang/shared/data/ErrorResponse;", "(ILjava/lang/Object;Lcom/makeshop/podbbang/shared/data/ErrorResponse;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getError", "()Lcom/makeshop/podbbang/shared/data/ErrorResponse;", "setError", "(Lcom/makeshop/podbbang/shared/data/ErrorResponse;)V", "getStatus", "()I", "component1", "component2", "component3", "copy", "(ILjava/lang/Object;Lcom/makeshop/podbbang/shared/data/ErrorResponse;)Lcom/makeshop/podbbang/shared/data/CommonResponse;", "equals", "", "other", "hashCode", "toString", "", "shared_debug"})
public final class CommonResponse<T extends java.lang.Object> {
    private final int status = 0;
    private final T data = null;
    @org.jetbrains.annotations.NotNull()
    private com.makeshop.podbbang.shared.data.ErrorResponse error;
    
    public CommonResponse(int status, T data, @org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.ErrorResponse error) {
        super();
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final T getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.ErrorResponse getError() {
        return null;
    }
    
    public final void setError(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.ErrorResponse p0) {
    }
    
    public final int component1() {
        return 0;
    }
    
    public final T component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.ErrorResponse component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.CommonResponse<T> copy(int status, T data, @org.jetbrains.annotations.NotNull()
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