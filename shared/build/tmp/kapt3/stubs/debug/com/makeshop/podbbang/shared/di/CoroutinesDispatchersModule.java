package com.makeshop.podbbang.shared.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/makeshop/podbbang/shared/di/CoroutinesDispatchersModule;", "", "()V", "providesDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "providesIoDispatcher", "providesMainDispatcher", "providesMainImmediateDispatcher", "DefaultDispatcher", "IoDispatcher", "MainDispatcher", "MainImmediateDispatcher", "shared_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class CoroutinesDispatchersModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule INSTANCE = null;
    
    private CoroutinesDispatchersModule() {
        super();
    }
    
    @dagger.Provides()
    @com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule.DefaultDispatcher()
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineDispatcher providesDefaultDispatcher() {
        return null;
    }
    
    @dagger.Provides()
    @com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule.IoDispatcher()
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineDispatcher providesIoDispatcher() {
        return null;
    }
    
    @dagger.Provides()
    @com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule.MainDispatcher()
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineDispatcher providesMainDispatcher() {
        return null;
    }
    
    @dagger.Provides()
    @com.makeshop.podbbang.shared.di.CoroutinesDispatchersModule.MainImmediateDispatcher()
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineDispatcher providesMainImmediateDispatcher() {
        return null;
    }
    
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @javax.inject.Qualifier()
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/makeshop/podbbang/shared/di/CoroutinesDispatchersModule$DefaultDispatcher;", "", "shared_debug"})
    public static abstract @interface DefaultDispatcher {
    }
    
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @javax.inject.Qualifier()
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/makeshop/podbbang/shared/di/CoroutinesDispatchersModule$IoDispatcher;", "", "shared_debug"})
    public static abstract @interface IoDispatcher {
    }
    
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @javax.inject.Qualifier()
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/makeshop/podbbang/shared/di/CoroutinesDispatchersModule$MainDispatcher;", "", "shared_debug"})
    public static abstract @interface MainDispatcher {
    }
    
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @javax.inject.Qualifier()
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/makeshop/podbbang/shared/di/CoroutinesDispatchersModule$MainImmediateDispatcher;", "", "shared_debug"})
    public static abstract @interface MainImmediateDispatcher {
    }
}