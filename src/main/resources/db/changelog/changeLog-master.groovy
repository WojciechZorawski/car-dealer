package db.changelog

databaseChangeLog {

  changeSet(id: 'Create car table', author: 'wzorawski') {
    preConditions(onFail: 'MARK_RAN') {
      not() {
        tableExists(tableName: "car")
      }
    }
    createTable(tableName: 'car') {
      column(name: 'id', type: 'bigint', autoIncrement: true) {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'brand', type: 'varchar(20)') {}
      column(name: 'model', type: 'varchar(20)') {}
      column(name: 'price', type: 'bigint') {}
      column(name: 'brokerage', type: 'double precision') {}
    }
    createSequence(sequenceName: 'SEQ_car', startValue: '1')
  }
}