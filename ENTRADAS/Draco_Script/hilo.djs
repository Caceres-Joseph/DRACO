
        System.out.println("Antes de ejecutar");
        SingleSelectionModel<Tab> selectionModel = tabClases.getSelectionModel();
        int indice = selectionModel.getSelectedIndex();
        txtConsola.setText("");
//        simbolo.listaTabsClases.ejecutarNodo(indice);
//               Platform.runLater(() -> {  
//                    simbolo.listaTabsClases.ejecutarNodo(indice);
//                });
 
         tarea = new elementoHilo() {
             volatile boolean halt = false;
             Object o  = new Object();
            @Override
            protected Integer call() throws Exception {
                return 0;
            }
            @Override
            public void run(){ 
                       
                
            
                println("Deteniendo hilo"); 
                simbolo.listaTabsClases.ejecutarNodo(indice);
                println("Se termino el flujo");
            } 
            
            @Override
            public boolean cancel(boolean bol){
                println("Cancelando"+String.valueOf(al++));
                 return super.cancel();
                
            } 
            
        };
          
        backgroundThread = new Thread(tarea);
//        backgroundThread.setDaemon(true);
        println("Corriendo hilo");
        backgroundThread.start();
//        
//        
//        Platform.runLater(() -> {
//        new Thread(tarea).start();
//        tarea.run();
////           tarea.run();
//        });

//        
//        
//        
//        new Thread(tarea).start();
//        tarea.run();

//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                Platform.runLater(new Runnable() {
//
//                    public void run() {
//
//                        System.out.println("Thread Running");
//                        SingleSelectionModel<Tab> selectionModel = tabClases.getSelectionModel();
//                        int indice = selectionModel.getSelectedIndex();
//                        txtConsola.setText("");
//                        simbolo.listaTabsClases.ejecutarNodo(indice);
//                    }
//                });
//
//                System.out.println("despues de ejecutar");
//            }
//        };
//        thread.start();



//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("Thread Running");
// 
//                    SingleSelectionModel<Tab> selectionModel = tabClases.getSelectionModel();
//                    int indice = selectionModel.getSelectedIndex();
//                    txtConsola.setText("");
//                    simbolo.listaTabsClases.ejecutarNodo(indice); 
//                System.out.println("despues de ejecutar");
//            }
//        };
//        thread.start();




//        ejecut(indice);
//        System.out.println("123");
////        Platform.runLater(() -> {
//            System.out.println("jajaja");
////            simbolo.listaTabsClases.ejecutarNodo(indice);
//            System.out.println("jejeje");
//            Thread thread = new Thread() {
//                @Override
//                public void run() {
//                    Platform.runLater(() -> {
//                        simbolo.listaTabsClases.ejecutarNodo(indice);
//                    });
//                }
//            };
//
//            thread.start();
////        });
//        System.out.println("543");
//        simbolo.hiloEjecucion.ejecutar(indice);
        
//        simbolo.listaTabsClases.ejecutarNodo(indice); 
        