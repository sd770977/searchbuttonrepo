
$(document).ready(function () {
  $('#searchResultTable').DataTable({
	  "pagingType": "full_numbers",
	  "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
	  "paging": true,
	  "searching": true,
      "ordering": true
  });
  $('.dataTables_length').addClass('bs-select');
});